import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int numThreads = 10;
        Random rnd = new Random();
        for(int i = 0; i<numThreads; i++) {
            int step = rnd.nextInt(1, 10);
            BreakThread breakThread = new BreakThread();

            new SequenceThread(i, step, breakThread).start();

        }



    }
}