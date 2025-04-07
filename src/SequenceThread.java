public class SequenceThread extends Thread{

    private final int id;
    private final int step;

    private final BreakThread breakThread;
    public SequenceThread(int id, int step, BreakThread breakThread) {
        this.id = id;
        this.step = step;
        this.breakThread = breakThread;
        new Thread(this.breakThread).start();

    }

    @Override
    public void run() {
        long sum = 0;
        int iter = 0;
        boolean isStop = false;

        do {
            sum += step;
            iter++;
            isStop = breakThread.IsBreak();
        }
        while(!isStop);

        System.out.println("Потік № " + id + "; ітерації: " + iter + "; сума: " + sum);
    }
}
