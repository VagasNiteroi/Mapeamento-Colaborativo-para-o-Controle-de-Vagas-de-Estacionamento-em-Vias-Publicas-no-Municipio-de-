package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ConnectionFactory {

    private static final String DRIVE = "org.postgresql.Driver";
    private static final String URL =
            "jdbc:postgresql://node4131-vagas-niteroi.users.scale.virtualcloud.com.br/vagas";
    private static final String USER = "webadmin";
    private static final String PASS = "AGEsis67584";

    public static Connection createConnection() throws ClassNotFoundException, SQLException {

        try {
            Class.forName(DRIVE);
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            if (conn != null) {
                return conn;
            }

        } catch (SQLException e) {

        }
        return null;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement stmt) {
        closeConnection(conn);
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {
        closeConnection(conn, stmt);
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
