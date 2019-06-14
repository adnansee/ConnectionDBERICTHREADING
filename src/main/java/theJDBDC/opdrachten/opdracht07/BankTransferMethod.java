package theJDBDC.opdrachten.opdracht07;

import java.sql.*;

public class BankTransferMethod {
    private static final String QUERY = "select * from Accounts where number = ?";
    private static final String UPDATE = "update Accounts set amount = ? where number = ?";


    public  void transfert() throws Exception {

        try (Connection con = DriverManager.getConnection("jdbc:mariadb://noelvaes.eu/StudentDB?", "student", "student123");) {
            con.setAutoCommit(false);
            con.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);


            try (PreparedStatement qstmt = con.prepareStatement(QUERY);
                 PreparedStatement ustmt = con.prepareStatement(UPDATE)) {
                setAmount(ustmt, 1, 100);
                setAmount(ustmt, 2, 0);

                double amount1 = 0;
                double amount2 = 0;
                while ((amount1 = getAmount(qstmt, 1)) > 0) {// tx start
                    amount2 = getAmount(qstmt, 2);
                    setAmount(ustmt,1,amount1 -=1);
                    setAmount(ustmt,2,amount2 +=1);
                    System.out.println(amount1 + "\t" + amount2);
                    con.commit(); //tx end


                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                con.rollback();

            }

        }
    }

    public static void setAmount(PreparedStatement ustmt, int number, double amount) throws SQLException {
        ustmt.setInt(2, number);
        ustmt.setDouble(1, amount);
        ustmt.executeUpdate();
    }

    public static double getAmount(PreparedStatement qstmt, int number) throws SQLException {
        double amount = 0;
        qstmt.setInt(1, number);
        try (ResultSet rs = qstmt.executeQuery()) {
            if (rs.next()) {
                amount = rs.getDouble("amount");
            }
        }
        return amount;
    }
}