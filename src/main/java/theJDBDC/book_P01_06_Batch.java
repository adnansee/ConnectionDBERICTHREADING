package theJDBDC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class book_P01_06_Batch {


    public static void main(String[] args) {
        String sql = "INSERT INTO beers(Name,BrewerId,CategoryId,Price,Stock) VALUES ('Hapkins',6,22,250,10)";
        String url = "jdbc:mysql://localhost:3306/beers_db?useSSL=false";
        try (Connection con = DriverManager.getConnection(url, "root", "admin");
             Statement statement = con
                     .createStatement()) {


            con.setAutoCommit(false);

            statement.addBatch("UPDATE BEERS set Price  = 3.1  where Name like 'Jupiler'");

            statement.addBatch("UPDATE beers set Alcohol = 40  where name ='barbar'");
            statement.executeBatch();

            con.commit();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}
