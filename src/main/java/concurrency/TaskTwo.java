package concurrency;


import model.Match;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class TaskTwo implements Runnable {

    private final String[] nations;
    private final int[] penaltyWinPercentages;
    private final List<Match> matchList;

    public TaskTwo(String[] nations, List<Match> matchList) {
        this.nations = nations;
        this.penaltyWinPercentages = new int[nations.length];
        this.matchList = matchList;
    }

    @Override
    public void run() {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, nations.length);

        var filteredList = IntStream.range(0, nations.length)
                .filter(index -> penaltyWinPercentages[index] == randomIndex)
                .mapToObj(i -> String.format("Nation: %s, Penalty Win Percentage: %d%%", nations[i], penaltyWinPercentages[i]))
                .toList();

        if (filteredList.isEmpty()) {
            System.out.println("No records found with a penalty win percentage of " + randomIndex + "%");
        } else {
            filteredList.forEach(System.out::println);
        }
    }
}
