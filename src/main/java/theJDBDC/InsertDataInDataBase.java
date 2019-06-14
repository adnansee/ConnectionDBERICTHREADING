package theJDBDC;

import java.sql.*;

public class InsertDataInDataBase {


    public static void main(String[] args) {
        String sql = "INSERT INTO beers(Name,BrewerId,CategoryId,Price,Stock) VALUES ('Hapkins',6,22,250,10)";
        String url = "jdbc:mysql://localhost:3306/beers_db?useSSL=false";
        try (Connection con = DriverManager.getConnection (url, "root", "admin");
        ) {
            System.out.println ("Connection established");

            Statement statement = con.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            int insert = statement.executeUpdate (sql);
            System.out.println (insert);

        } catch (SQLException e) {
            System.out.println (e.getMessage ());
        }

    }
}