package theJDBDC.opdrachten.opdracht02;

import java.sql.*;

public class SearchBeer {
    public static void main(String[] args) {
        String sql = "SELECT beers.Id, beers.name  as name, Alcohol, Stock, brewers.Name as brewer, Categories.Category as category\n" +
                "FROM categories\n" +
                "    join beers  on categories.Id = beers.CategoryId\n" +
                "join brewers on beers.BrewerId = brewers.Id\n" +
                "WHERE Alcohol > 9\n" +
                "ORDER BY Alcohol desc\n" +
                ";";

        String url = "jdbc:mysql://localhost:3306/beers_db?useSSL=false";
        try (Connection con = DriverManager.getConnection (url, "root", "admin");
        ) {
            System.out.println ("Connection established");

            Statement statement = con.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery (sql);

            System.out.printf ("%-10s %-80s %10s %10s %10s %10s \n","id" , "name" , "stock" , "Alcohol","Brewer","Category");
            while (rs.next ()) {
                int id = rs.getInt ("beers.id");
                String name = rs.getString ("name");
                int stock = rs.getInt ("stock");
                double alcohol = rs.getDouble ("Alcohol");
                String brewer = rs.getString ("brewer");
                String category = rs.getString ("category");

                System.out.printf ("%-10d %-80s %10d %10.1f  %20s  %20s  \n",id , name , stock , alcohol, brewer,category);
            }


        } catch (SQLException e) {
            System.out.println (e.getMessage ());

        }

    }
}