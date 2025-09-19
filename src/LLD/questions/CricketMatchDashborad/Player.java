package LLD.questions.CricketMatchDashborad;

public class Player {
    private String name;
    private int runs;
    private int ballsFaced;
    private int fours;
    private int sixes;
    private boolean isOut;
    private boolean onStrike;
    private boolean isActive;

    public void scoreRuns(int runs) {
        this.runs += runs;
        this.ballsFaced += 1;
        if (runs == 4) this.fours += 1;
        if (runs == 6) this.sixes += 1;
    }

    public void getOut() {
        this.isOut = true;
        this.isActive = false;
    }

    public void changeStrike() {
        this.onStrike = !this.onStrike;
    }

    public Player(String name) {
        this.name = name;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        String star = (isActive) ? "*" : "";
        return name + star + " " + runs + " " + fours + " " + sixes + " " + ballsFaced;
    }
}
