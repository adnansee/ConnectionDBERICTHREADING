package theJDBDC;

import java.sql.*;

public class PreparedStatemntDataBase {


    public static void main(String[] args) {
        String sql = "INSERT INTO beers(Name,BrewerId,CategoryId,Price,Stock) VALUES ('Hapkins',6,22,250,10)";
        String url = "jdbc:mysql://localhost:3306/beers_db?useSSL=false";
        try (Connection con = DriverManager.getConnection(url, "root", "admin");
             PreparedStatement ps = con
                     .prepareStatement("UPDATE BEERS set Price  = ?  where Name =?")) {
            ps.setDouble(1, 5.20);
            ps.setString(2, "Zulte");
            int result = ps.executeUpdate();
            System.out.println(result);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}