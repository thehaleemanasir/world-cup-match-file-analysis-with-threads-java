package concurrency;


import model.Match;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TaskTwo implements Runnable {

    private final String[] nations;
    private final int[] penaltyWinPercentages;
    private final List<Match> matchList;

    public TaskTwo(String[] nations, List<Match> matchList) {
        this.nations = nations;
        this.penaltyWinPercentages = new int[nations.length];
        this.matchList = matchList;
        calculatePenaltyWinPercentages();
    }

    private void calculatePenaltyWinPercentages() {
        for (int i = 0; i < nations.length; i++) {
            String nation = nations[i];
            long totalMatches = matchList.stream()
                    .filter(match -> match.getHome_team().equals(nation) || match.getAway_team().equals(nation))
                    .count();
            long penaltyWins = matchList.stream()
                    .filter(match -> (match.getHome_team().equals(nation) || match.getAway_team().equals(nation)) && match.getWin_conditions() != null && match.getWin_conditions().toLowerCase().contains("penalties"))
                    .count();

            if (totalMatches > 0) {
                penaltyWinPercentages[i] = (int) ((penaltyWins / (double) totalMatches) * 100);
            } else {
                penaltyWinPercentages[i] = 0;
            }
        }
    }

    @Override
    public void run() {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, nations.length);
        String selectedNation = nations[randomIndex];
        int penaltyWinPercentage = penaltyWinPercentages[randomIndex];

        System.out.printf("%% of games that %s has won on penalties %d%%%n", selectedNation, penaltyWinPercentage);
    }
}