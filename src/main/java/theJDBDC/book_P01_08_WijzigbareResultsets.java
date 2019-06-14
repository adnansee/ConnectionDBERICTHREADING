package theJDBDC;

import java.sql.*;
import java.sql.ResultSet;

public class book_P01_08_WijzigbareResultsets {


    public static void main(String[] args) {
       // String sql = "INSERT INTO beers(Name,BrewerId,CategoryId,Price,Stock) VALUES ('Hapkins',6,22,250,10)";
        String url = "jdbc:mysql://localhost:3306/beers_db?useSSL=false";
        try (Connection con = DriverManager.getConnection(url, "root", "admin");
             Statement statement = con
                     .createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE)) {

           ResultSet   resultSet = statement.executeQuery("SELECT * from beers");
           /* resultSet.moveToInsertRow();;
            resultSet.updateString("Name","Dell");
            resultSet.updateDouble("Price",6.7);
            resultSet.updateDouble("Alcohol",12);
            resultSet.insertRow();*/

          resultSet.afterLast();
            resultSet.previous();
           // resultSet.deleteRow();
            resultSet.updateDouble("Price",483.5);
            resultSet.updateRow();


            /*con.setAutoCommit(false);

            statement.addBatch("UPDATE BEERS set Price  = 3.1  where Name like 'Jupiler'");

            statement.addBatch("UPDATE beers set Alcohol = 40  where name ='barbar'");
            statement.executeBatch();

            con.commit();
*/

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}
