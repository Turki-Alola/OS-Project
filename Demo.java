/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CS330;

/**
 *
 * @author turki
 */
public class Demo extends Thread {

    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        int quantum = 5000;
        int mod = 0;
        PBuffer pBuffer = PBuffer.getInstance();
        ProcessQueue readyQueue = ProcessQueue.getInstance();
        LettersCreator letters = new LettersCreator();
        NumbersCreator numbers = new NumbersCreator();
        letters.start();
        numbers.start();
        pBuffer.start();
        System.out.println(readyQueue.get());

        while (true) {
            mod = count % readyQueue.getSize();
            if (readyQueue.get(mod) != null) {
                if (readyQueue.get(mod).isAlive()) {
                    System.out.println("Resuming: " + readyQueue.get(mod).getName());
                    readyQueue.get(mod).resume();
                } else {
                    System.out.println("Starting: " + readyQueue.get(mod).getName());
                    readyQueue.get(mod).start();
                }
                Thread.sleep(quantum);
                System.out.println("\nSuspending: " + readyQueue.get(mod).getName() + "\n");
                readyQueue.get(mod).suspend();
                System.out.println(readyQueue.get());
                System.out.println("\n-------------------\n" + readyQueue.get(mod) + " REMOVED");
                readyQueue.remove(readyQueue.get(mod));
                System.out.println("-------------------\n" + readyQueue.get() + "\n-------------------");
            }
            count++;
            pBuffer.start();
        }
    }
}
