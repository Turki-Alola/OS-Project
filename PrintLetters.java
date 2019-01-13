package CS330;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintLetters extends Thread {

    int i = 0;
    private String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    @Override
    public void run() {
        synchronized (this) {
            while (true) {
               
                    try {
                        System.out.println("Printing Letters " + alpha[i++ % 26]);
                        

                        Thread.sleep(1000);

                    } catch (InterruptedException ex) {
                        Logger.getLogger(PrintLetters.class.getName()).log(Level.SEVERE, null, ex);
                    }

                
            }
        }
    }
}
