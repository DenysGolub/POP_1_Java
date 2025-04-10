class ThreadInfo {
    int id;
    int time;
    volatile boolean canStop = false;
    ThreadInfo(int id, int time) {
        this.id = id;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getTime() {
        return time;
    }

    public void minusTime(int t) {
        time -= t;
    }

    public void setFlag() {
        canStop = true;
    }
    public boolean getFlag() {
        return canStop;
    }
}
