package repository.background;

import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.IntFunction;

import static constants.Consts.CATCH_EXCEPTION;

/**
 * Утильный класс. Берёт на себя большую часть работы с запросами.
 * <p>
 * Все методы имеют парметр params: Object... params
 * Если хотя бы одно значение передано, то будет использован PreparedStatement,
 * и все значения params будут переданы в запрос.
 * <p>
 * Если параметров передано не было, то используется Statement
 * <p>
 * Класс DaoBackground является дженериком,
 * и специализироваться должен типом объекта Pojo.
 * <p>
 * Конструктор принимает три параметра - все функциональные интерфейсы.
 * Function<Object[], T> pojoMaker - создатель объектов Pojo
 * IntFunction<T[]> pojoArrayMaker - создатель массива объектов Pojo
 * BiConsumer<T, Object[]> pojoPusher - пушер объектов Pojo
 */
public class DaoBackground<T> {
    private static final Logger LOGGER = Logger.getLogger(DaoBackground.class);
    private final Function<Object[], T> pojoMaker;
    private final IntFunction<T[]> pojoArrayMaker;
    private final BiConsumer<T, Object[]> pojoPusher;

    /**
     * Конструктор принимает три параметра - все функциональные интерфейсы.
     * Function<Object[], T> pojoMaker - создатель объектов Pojo
     * IntFunction<T[]> pojoArrayMaker - создатель массива объектов Pojo
     * BiConsumer<T, Object[]> pojoPusher - пушер объектов Pojo
     *
     * @param pojoMaker
     * @param pojoArrayMaker
     * @param pojoPusher
     */
    public DaoBackground(Function<Object[], T> pojoMaker,
                         IntFunction<T[]> pojoArrayMaker,
                         BiConsumer<T, Object[]> pojoPusher
    ) {
        this.pojoMaker = pojoMaker;
        this.pojoArrayMaker = pojoArrayMaker;
        this.pojoPusher = pojoPusher;
    }

    /**
     * Пробегает по столбцам в source (результат SQL запроса)
     * и возвращает массив значений (Object[])
     *
     * @param source
     * @return Object[]
     * @throws SQLException
     */
    private static Object[] internalObjArrayFromResultSet(ResultSet source) throws SQLException {
        Object[] result = new Object[source.getMetaData().getColumnCount()];

        for (int iColumn = 0; iColumn < result.length; ++iColumn) {
            result[iColumn] = source.getObject(iColumn + 1);
        }

        return result;
    }

    /**
     * Исполняет запрос sql.
     * Возвращает true, если всё ок.
     * <p>
     * Метод имеет парметр params: Object... params
     * Если хотя бы одно значение передано, то будет использован PreparedStatement,
     * и все значения params будут переданы в запрос.
     * <p>
     * Если параметров передано не было, то используется Statement
     *
     * @param sql
     * @param params
     * @return
     */
    public static boolean execute(String sql, Object... params) {
        try (DaoStatement statement = new DaoStatement(sql, params)) {
            return statement.execute();
        } catch (SQLException e) {
            LOGGER.error(CATCH_EXCEPTION, e);
        }
        return false;
    }


    /**
     * Функциональный интерфейс.
     *
     * @param <T>
     */
    interface sqlExecute<T> {
        T execute(ResultSet resultSet) throws SQLException;
    }

    /**
     * Исполняет запрос sql.
     * дженерик - возвращаемое значение зависит от
     * параметра sqlExecute<T> executor (функциональноый интерфейс),
     * который позволяет выполнять
     * произвольный код внутри конструкции try catch
     * <p>
     * Метод имеет парметр params: Object... params
     * Если хотя бы одно значение передано, то будет использован PreparedStatement,
     * и все значения params будут переданы в запрос.
     * <p>
     * Если параметров передано не было, то используется Statement
     *
     * @param sql
     * @param executor
     * @param params
     * @param <T>
     * @return
     */
    public static <T> T fetch(String sql, sqlExecute<T> executor, Object... params) {
        try (DaoStatement statement = new DaoStatement(sql, params);
             ResultSet resultSet = statement.executeQuery()) {
            return executor.execute(resultSet);
        } catch (SQLException e) {
            LOGGER.trace(CATCH_EXCEPTION, e);
        }
        return null;
    }

    /**
     * Исполняет запрос sql,
     * возвращает первое значение в первой строке
     * результатов запроса (ResultSet resultSet).
     * Остальные результаты запроса игнорируются.
     * <p>
     * Если запрос ничего не вернул, или выполнен с ошибкой
     * данный метод вернёт null.
     * <p>
     * Метод имеет парметр params: Object... params
     * Если хотя бы одно значение передано, то будет использован PreparedStatement,
     * и все значения params будут переданы в запрос.
     * <p>
     * Если параметров передано не было, то используется Statement
     *
     * @param sql
     * @param params
     * @return
     */
    public static Object fetchOneFieldAsObject(String sql, Object... params) {
        return fetch(sql, resultSet -> {
            return (resultSet != null && resultSet.next() && resultSet.getMetaData().getColumnCount() > 0) ?
                    resultSet.getObject(1) :
                    null;
        }, params);
    }

    /**
     * Исполняет запрос sql,
     * возвращает все значения из первой строки
     * результатов запроса (ResultSet resultSet)
     * в виде массива (Object[]).
     * Остальные результаты запроса игнорируются.
     * <p>
     * Если запрос ничего не вернул, или выполнен с ошибкой
     * данный метод вернёт массив нулевой длины (new Object[0]).
     * <p>
     * Метод имеет парметр params: Object... params
     * Если хотя бы одно значение передано, то будет использован PreparedStatement,
     * и все значения params будут переданы в запрос.
     * <p>
     * Если параметров передано не было, то используется Statement
     *
     * @param sql
     * @param params
     * @return
     */
    public static Object[] fetchOneRowAsObjArray(String sql, Object... params) {
        return fetch(sql, resultSet -> {
            return (resultSet != null && resultSet.next()) ?
                    internalObjArrayFromResultSet(resultSet) :
                    new Object[0];
        }, params);
    }

    /**
     * Исполняет запрос sql,
     * все значения из первой строки
     * результатов запроса (ResultSet resultSet)
     * пушером (pojoPusher - функциональный интерфейс, задаётся в конструкторе)
     * загоняются в объект destPojo (передаётся в функцию в параметрах).
     * Остальные результаты запроса игнорируются.
     * Возвращает true.
     * <p>
     * Если запрос ничего не вернул, или выполнен с ошибкой
     * данный метод вернёт false.
     * <p>
     * Метод имеет парметр params: Object... params
     * Если хотя бы одно значение передано, то будет использован PreparedStatement,
     * и все значения params будут переданы в запрос.
     * <p>
     * Если параметров передано не было, то используется Statement
     *
     * @param destPojo
     * @param sql
     * @param params
     * @return
     */
    public boolean fetchOneRowAsPojoObject(T destPojo, String sql, Object... params) {
        Object[] fields = fetchOneRowAsObjArray(sql, params);

        if (fields.length == 0) {
            return false;
        } else {
            pojoPusher.accept(destPojo, fields);
            return true;
        }
    }

    /**
     * Исполняет запрос sql,
     * все значения из первой строки
     * передаются в конструктов объекта Pojo,
     * Остальные результаты запроса игнорируются.
     * Возвращает true.
     * <p>
     * Если запрос ничего не вернул, или выполнен с ошибкой
     * данный метод вернёт null.
     * <p>
     * Метод имеет парметр params: Object... params
     * Если хотя бы одно значение передано, то будет использован PreparedStatement,
     * и все значения params будут переданы в запрос.
     * <p>
     * Если параметров передано не было, то используется Statement
     *
     * @param sql
     * @param params
     * @return
     */
    public T fetchOneRowAsPojoObject(String sql, Object... params) {
        Object[] fields = fetchOneRowAsObjArray(sql, params);
        return fields.length == 0 ? null : pojoMaker.apply(fields);
    }

    /**
     * Исполняет запрос sql,
     * все значения из первой строки
     * передаются в конструктор объекта Pojo,
     * Остальные результаты запроса игнорируются.
     * Возвращает true.
     * <p>
     * Если запрос ничего не вернул, или выполнен с ошибкой
     * данный метод вернёт null.
     *
     * @param sql
     * @param params
     * @return
     */
    public T[] fetchRowsAsPojoArray(String sql, Object... params) {
        List<T> pojoList = fetchRowsAsPojoList(sql, params);
        return pojoList.toArray(pojoArrayMaker.apply(pojoList.size()));
    }

    public List<T> fetchRowsAsPojoList(String sql, Object... params) {
        return fetch(sql, resultSet -> {
            if (resultSet != null) {
                List<T> pojoList = new ArrayList<>();

                while (resultSet.next()) {
                    pojoList.add(pojoMaker.apply(internalObjArrayFromResultSet(resultSet)));
                }

                return pojoList;
            } else {
                return Collections.emptyList();
            }
        }, params);
    }
}
