package LLD.practice.CricketMatchDashborad;

import java.util.Scanner;

public class Match {
    private Team team1;
    private Team team2;
    private int totalOvers;
    private Inning firstInning;
    private Inning secondInning;

    public Match(Team team1, Team team2, int totalOvers) {
        this.team1 = team1;
        this.team2 = team2;
        this.totalOvers = totalOvers;
    }

    public void startMatch() {
        System.out.println("First Innings: " + team1.getName() + " batting");
        firstInning = new Inning(team1, totalOvers);
        playInning(firstInning);

        System.out.println("Second Innings: " + team2.getName() + " batting");
        secondInning = new Inning(team2, totalOvers);
        playInning(secondInning);

        decideWinner();
    }

    private void playInning(Inning inning) {
        Scanner scanner = new Scanner(System.in);

        while (!inning.isCompleted()) {
            System.out.println("Enter ball result (e.g., 0,1,2,3,4,6,W,Wd,Nb): ");
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                inning.playBall(input);
            }
        }
    }

    private void decideWinner() {
        int team1Score = team1.getTotalRuns();
        int team2Score = team2.getTotalRuns();

        System.out.println("Result:");
        if (team1Score > team2Score) {
            int margin = team1Score - team2Score;
            System.out.println(team1.getName() + " won the match by " + margin + " runs.");
        } else if (team2Score > team1Score) {
            int margin = team2Score - team1Score;
            System.out.println(team2.getName() + " won the match by " + margin + " runs.");
        } else {
            System.out.println("Match Tied!");
        }
    }
}

