package LLD.questions.CricketMatchDashborad;

import java.util.Arrays;
import java.util.List;

public class RunnerClass {
    public static void main(String[] args) {
        List<String> team1Players = Arrays.asList("P1", "P2", "P3", "P4", "P5");
        List<String> team2Players = Arrays.asList("P6", "P7", "P8", "P9", "P10");

        Team team1 = new Team("Team1", team1Players);
        Team team2 = new Team("Team2", team2Players);

        Match match = new Match(team1, team2, 2); // 2 overs
        match.startMatch();
    }
}
