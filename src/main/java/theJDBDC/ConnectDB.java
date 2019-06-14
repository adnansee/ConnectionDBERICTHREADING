package theJDBDC;

import java.sql.*;

public class ConnectDB {


    public static void main(String[] args) {
        String sql = "SELECT * FROM Beers";
        String url = "jdbc:mysql://localhost:3306/beers_db?useSSL=false";
        try (Connection con = DriverManager.getConnection (url, "root", "admin");
        ) {
            System.out.println ("Connection established");

            Statement statement = con.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery (sql);

            rs.afterLast ();
            while (rs.previous ()) {
                int id = rs.getInt ("id");
                String name = rs.getString ("name");
                int stock = rs.getInt ("stock");
                double price = rs.getDouble ("Price");
                System.out.println (id + " " + name + " " + stock + " " + price);
            }


        } catch (SQLException e) {

        }

    }
}