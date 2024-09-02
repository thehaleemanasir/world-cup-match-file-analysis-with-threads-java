package concurrency;


import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class TaskTwo  implements  Runnable{

    private final String[] nations;
    private final int[] penaltyWinPercentages;

    public TaskTwo(String[] nations, int[] penaltyWinPercentages) {
        this.nations = nations;
        this.penaltyWinPercentages = penaltyWinPercentages;
    }

    @Override
    public void run() {

        var min = 0;
        var max = 100;

        int randomPercentage = ThreadLocalRandom.current().nextInt(min, max + 1);

        var filteredList = IntStream.range(0, nations.length)
                .filter(i -> penaltyWinPercentages[i] == randomPercentage)
                .mapToObj(i -> String.format("Nation: %s, Penalty Win Percentage: %d%%", nations[i], penaltyWinPercentages[i]))
                .toList();

        if (filteredList.isEmpty()) {
            System.out.println("No records found with a penalty win percentage of " + randomPercentage + "%");
        } else {
            filteredList.forEach(System.out::println);
        }



    }


}
