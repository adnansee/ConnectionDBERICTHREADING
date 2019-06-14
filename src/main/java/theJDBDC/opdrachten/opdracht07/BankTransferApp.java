package theJDBDC.opdrachten.opdracht07;

public class BankTransferApp {

    public static void main(String[] args) throws Exception {
        BankTransferMethod bt = new BankTransferMethod();
        Thread t1 = new Thread(()-> {
            try {
                bt.transfert();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()-> {
            try {
                bt.transfert();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
       t1.start();
        t2.start();
    }
}
