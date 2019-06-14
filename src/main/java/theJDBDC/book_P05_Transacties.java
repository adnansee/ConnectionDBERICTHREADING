package theJDBDC;

import java.sql.*;

public class book_P05_Transacties {


    public static void main(String[] args) {
        String sql = "INSERT INTO beers(Name,BrewerId,CategoryId,Price,Stock) VALUES ('Hapkins',6,22,250,10)";
        String url = "jdbc:mysql://localhost:3306/beers_db?useSSL=false";
        try (Connection con = DriverManager.getConnection(url, "root", "admin");
             Statement statement = con
                     .createStatement()) {


            con.setAutoCommit(false);

            int r1 = statement.executeUpdate("UPDATE BEERS set Price  = 35  where Name like '%kriek%'");
            System.out.println("r1: " + r1);
            int r2 = statement.executeUpdate("UPDATE brewers set name = 'joe'  where id =2");
            System.out.println("r2: " + r2);
            con.commit();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}