package LLD.practice.CricketMatchDashborad;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;
    private int totalRuns;
    private int totalWickets;
    private int extras;
    private int nextBatsManIndex;

    public Team(String name, List<String> playerNames) {
        this.name = name;
        this.players = new ArrayList<>();
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
    }

    public Player getNextBatsman() {
        return nextBatsManIndex <= players.size() ? players.get(nextBatsManIndex++) : null;
    }

    public void addRuns(int runs) {
        this.totalRuns += runs;
    }

    public void addExtras(int runs) {
        this.totalRuns += runs;
        this.extras += runs;
    }

    public void loseWicket() {
        this.totalWickets += 1;
    }

    public String getName() {
        return this.name;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public int getExtras() {
        return extras;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
