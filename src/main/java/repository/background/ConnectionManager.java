package repository.background;

import java.sql.Connection;

public interface ConnectionManager {
    Connection getConnection();
}
