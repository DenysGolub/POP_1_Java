import java.security.KeyStore;
import java.util.Random;

public class BreakThread implements Runnable {
    private boolean canBreak = false;

    @Override
    public void run() {
        Random rnd = new Random();
        int milisecondsForBreak = rnd.nextInt(100, 2000);
//        milisecondsForBreak = 2000;

        try {
            Thread.sleep(milisecondsForBreak);
//            System.out.println("Thread is sleeping");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        canBreak = true;
    }

    synchronized public boolean IsBreak() {
        return canBreak;
    }

}
