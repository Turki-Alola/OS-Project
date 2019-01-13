package CS330;

import java.util.Arrays;

public class PBuffer extends Thread {

    private int pointer = 0;
    private static int size = 20;
    private static Thread[] pBuffer = new Thread[size];
    private static PBuffer bufferInstance = null;
    ProcessQueue readyQueue = ProcessQueue.getInstance();

    public static PBuffer getInstance() {
        if (bufferInstance == null) {
            return new PBuffer();
        } else {
            return bufferInstance;
        }
    }

    @Override
    public void start() {
        while (true) {
            if (readyQueue.add(getThread())) {
               // System.out.println(readyQueue.get());
            } else {
               break;
            }
        }
    }

    public Thread getThread() {
        if (pBuffer[pointer % size] == null) {
            pointer++;
            return getThread();
        } else {
            return pBuffer[(pointer++) % size];
        }
    }

    public String get() {
        return Arrays.toString(pBuffer);
    }

    public Thread get(int i) {
        return pBuffer[i];
    }

    public boolean add(Thread t) {
        for (int i = 0; i < size; i++) {
            if (pBuffer[i] == null) {
                pBuffer[i] = t;
                return true;
            }
        }
        return false;
    }

    public boolean remove(Thread t) {
        for (int i = 0; i < size; i++) {
            if (pBuffer[i] == t) {
                pBuffer[i] = null;
                return true;
            }
        }
        return false;
    }
}
