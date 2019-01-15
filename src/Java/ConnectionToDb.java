package Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDb {

    private Connection con;
    private String user = "root";
    private String db = "zoo";
    private String url = "jdbc:mysql://localhost/" + db;

    public ConnectionToDb(){

        try {

            con = DriverManager.getConnection(url, user, "");
        } catch (SQLException e) {

            System.out.println("Fehler bei Verbindung : " + e + " " + e.getErrorCode());
        }

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("Fehler bei JDBC-Treiber" + e);
        } catch (Exception e) {
            System.out.println("Allgemeiner Fehler : " + e.getMessage());
        }
    }
}
