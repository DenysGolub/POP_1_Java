import java.awt.*;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;

public class BreakThread implements Runnable {

    ThreadInfo[] threadInfos;

    public BreakThread(int threadsNumber) {
        threadInfos = new ThreadInfo[threadsNumber];

        Random rnd = new Random();
        for (int i = 0; i < threadsNumber; i++) {
            int t = rnd.nextInt(2000, 5000);
            threadInfos[i] = new ThreadInfo(i, t);
        }

    }


    private void bubbleSort(ThreadInfo[] th) {
        int n = th.length;
        ThreadInfo temp;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(th[j-1].getTime() > th[j].getTime()){
                    //swap elements
                    temp = th[j-1];
                    th[j-1] = th[j];
                    th[j] = temp;
                }
            }
        }
    }

    private void minusValueFromArray(int current) {
        for(int i = 0; i < threadInfos.length; i++) {
            threadInfos[i].minusTime(current);
        }
//        System.out.println(current);

    }

    @Override
    public void run() {
        bubbleSort(threadInfos);

        for(int i = 0; i < threadInfos.length; i++)
        {
            int currentTime = threadInfos[i].getTime();
            try {
                Thread.sleep(currentTime);
                threadInfos[threadInfos[i].getId()].setFlag();
                minusValueFromArray(currentTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean IsBreak(int id) {
        return threadInfos[id].getFlag();
    }
}

