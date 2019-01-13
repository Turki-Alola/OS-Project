package CS330;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintNumbers extends Thread {
    int i = 0;
   
    @Override
    public void run() {
        synchronized (this) {
            while (true) {
                try {

                    System.out.println("Printing Numbers: " + i++);

                    Thread.sleep(1000);

                } catch (InterruptedException ex) {
             
                }
                
            }
        }
    }
}
