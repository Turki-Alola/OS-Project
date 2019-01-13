/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS330;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author turki
 */
public class LettersCreator extends Thread {

    ProcessQueue readyQueue = ProcessQueue.getInstance();
    PBuffer pBuffer = PBuffer.getInstance();

    @Override
    public void run() {
        while (true) {
            if (!pBuffer.add(new PrintLetters())) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(LettersCreator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
