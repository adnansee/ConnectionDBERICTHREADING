package theJDBDC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

    public class ConnectDBTest {
        public static void main(String[] args) {
            try {

                String url = "jdbc:mysql://localhost:3306/movies?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&useSSL=false";
                String user = "root";
                String passwd="admin";
//Connection
                Connection conn = DriverManager.getConnection(url, user, passwd);
//Statement
                Statement mystmt = conn.createStatement();
// executre sql query
                ResultSet myRs = mystmt.executeQuery("SELECT * FROM actor");
//Process teh result set
                while (myRs.next()){
                    System.out.println(myRs.getString("act_fname"));
                }

                mystmt.close();
                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }
