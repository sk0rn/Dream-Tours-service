package repository.background;

import org.apache.log4j.Logger;

import java.io.Closeable;
import java.sql.*;

import static constants.Consts.CATCH_EXCEPTION;

/**
 * декор. Скрывает работу с классами
 * Connection, Statement и PreparedStatement,
 * делает конструкции try...catch
 * при доступе к базе менее громоздкими.
 * <p>
 * Суть простая - в зависимости от наличия параметров
 * (для параметризованных запросов) используется либо
 * Statement, либо PreparedStatement.
 */
public class DaoStatement implements Closeable {
    private static final Logger LOGGER = Logger.getLogger(DaoStatement.class);
    private static final ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();
    private final Connection connection;
    private final Statement statement;
    private final PreparedStatement preparedStatement;
    private final String sql;

    /**
     * Получаем sql-запрос и параметры - params.
     * На основании это решаем, что использовать
     * Statement, либо PreparedStatement.
     *
     * @param sql
     * @param params
     * @throws SQLException
     */
    DaoStatement(String sql, Object... params) throws SQLException {
        connection = connectionManager.getConnection();
        this.sql = sql;

        if (params != null && params.length > 0) {
            statement = null;
            preparedStatement = connection.prepareStatement(sql);

            for (int iParam = 0; iParam < params.length; ++iParam) {
                preparedStatement.setObject(iParam + 1, params[iParam]);
            }

        } else {
            preparedStatement = null;
            statement = connection.createStatement();
        }
    }


    ResultSet executeQuery() throws SQLException {
        if (preparedStatement != null) return preparedStatement.executeQuery();
        else if (statement != null) return statement.executeQuery(sql);
        else return null;
    }

    boolean execute() throws SQLException {
        if (preparedStatement != null) return preparedStatement.execute();
        else if (statement != null) return statement.execute(sql);
        else return false;
    }

    @Override
    public void close() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.error(CATCH_EXCEPTION, e);
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(CATCH_EXCEPTION, e);
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error(CATCH_EXCEPTION, e);
            }
        }
    }
}
