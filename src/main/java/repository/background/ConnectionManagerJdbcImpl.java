package repository.background;

import org.apache.log4j.Logger;
import utils.config.ConfigReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static constants.Consts.CATCH_EXCEPTION;

public class ConnectionManagerJdbcImpl implements ConnectionManager {
    private static final Logger LOGGER = Logger.getLogger(ConnectionManagerJdbcImpl.class);
    private static ConnectionManager connectionManager;

    private ConnectionManagerJdbcImpl() {
    }

    public static ConnectionManager getInstance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManagerJdbcImpl();
        }
        return connectionManager;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(ConfigReader.getDbDriver());
            connection = DriverManager.getConnection(
                    ConfigReader.getDbUrl(),
                    ConfigReader.getDbUser(),
                    ConfigReader.getDbPass());
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.trace(CATCH_EXCEPTION, e);
        }
        return connection;
    }
}
