package CS330;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcessQueue {

    int count, pointer = 0;
    static int size = 10;
    private static Thread[] readyQueue = new Thread[size];
    private static ProcessQueue queueInstance = null;

    public static ProcessQueue getInstance() {
        if (queueInstance == null) {
            return new ProcessQueue();
        } else {
            return queueInstance;
        }
    }
    
public int getSize(){
    return size;
}
    public String get() {
        return Arrays.toString(readyQueue);
    }

    public Thread get(int i) {
        return readyQueue[i];
    }

    public boolean add(Thread t) {
        synchronized (readyQueue) {
            for (int i = 0; i < size - 1; i++) {
                if (readyQueue[i] == null) {
                    readyQueue[i] = t;
                    return true;
                }
            }
            return false;
        }
    }

    public boolean remove(Thread t) {
        for (int i = 0; i < size - 1; i++) {
            if (readyQueue[i] == t) {
                readyQueue[i] = null;
                return true;
            }
        }
        return false;

    }
}
