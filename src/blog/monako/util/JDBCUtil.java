package blog.monako.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
    static ComboPooledDataSource dataSource = null;
    static {
        dataSource = new ComboPooledDataSource();
    }
    public static DataSource getDataSource(){
        return dataSource;
    }
    // 获取连接对象
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // 释放资源
    public static void release(Connection connection, ResultSet resultSet, Statement statement) {
        closeConnection(connection);
        closeResultSet(resultSet);
        closeStatement(statement);
    }
    public static void release(Connection connection, Statement statement) {
        closeConnection(connection);
        closeStatement(statement);
    }
    private static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection = null;
        }
    }

    private static void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            resultSet = null;
        }
    }

    private static void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            statement = null;
        }
    }
}
