package theJDBDC.opdrachten.opdracht05;

import java.security.interfaces.RSAKey;
import java.sql.*;

public class AddBeer {


    public static void main(String[] args) {
        String sql = "INSERT INTO beers(Name,BrewerId,CategoryId,Price,Stock) VALUES ('Germany',6,22,250,10)";
        String url = "jdbc:mysql://localhost:3306/beers_db?useSSL=false";
        try (Connection con = DriverManager.getConnection (url, "root", "admin");
        ) {
            System.out.println ("Connection established");

            Statement statement = con.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            int insert = statement.executeUpdate (sql,Statement.RETURN_GENERATED_KEYS);
            try(ResultSet rs = statement.getGeneratedKeys ()){
                if(rs.next ()){
                    int id = rs.getInt (1);
                    System.out.println ("id created: " + id);
                }
            }
            System.out.println ("nbr records updated: "+insert);

        } catch (SQLException e) {
            System.out.println (e.getMessage ());
        }

    }
}