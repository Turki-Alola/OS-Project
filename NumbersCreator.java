/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
source control
    bitbucket
    github
testing
    jira
    sifter
    blitz
    load impact
    dead mans snitch
    eclips luna generator
    tarantola
    qa manager
    testobia
    test link
    bugzilla
 */
package CS330;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author turki
 */
public class NumbersCreator extends Thread {

    ProcessQueue readyQueue = ProcessQueue.getInstance();
    PBuffer pBuffer = PBuffer.getInstance();

    @Override
    public void run() {
        while (true) {
            if (!pBuffer.add(new PrintNumbers())) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(LettersCreator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
