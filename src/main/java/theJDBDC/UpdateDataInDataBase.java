package theJDBDC;

import java.sql.*;

public class UpdateDataInDataBase {


    public static void main(String[] args) {
        String sql = "Update beers set stock = 50 where name like '%Kriek%'";
        String url = "jdbc:mysql://localhost:3306/beers_db?useSSL=false";
        String urser = "root";
        String password = "admin";
        try (Connection con = DriverManager.getConnection (url, urser, password)
        ) {
            System.out.println ("Connection established");

            Statement statement = con.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            int updateRows  = statement.executeUpdate (sql);

            System.out.println (updateRows);


        } catch (SQLException e) {

        }

    }
}