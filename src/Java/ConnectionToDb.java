package Java;

import java.sql.*;

public class ConnectionToDb {

    private Connection con;
    private Statement stmt;
    private ResultSet rSet;

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

    public void setRset(String command) {

        try {
            stmt = con.createStatement();
            rSet = stmt.executeQuery(command);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public ResultSet getRset(){

        return rSet;
    }

}
