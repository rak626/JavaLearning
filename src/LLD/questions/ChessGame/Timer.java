package LLD.questions.ChessGame;

public class Timer {
    private int remainingTime; // in seconds

    public Timer(int timeInSeconds) {
        this.remainingTime = timeInSeconds;
    }

    public void decreaseTime(int seconds) {
        remainingTime -= seconds;
    }

    public boolean isTimeUp() {
        return remainingTime <= 0;
    }

    public int getRemainingTime() {
        return remainingTime;
    }
}
