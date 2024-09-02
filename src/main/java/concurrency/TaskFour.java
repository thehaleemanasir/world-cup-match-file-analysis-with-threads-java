package concurrency;

import model.Match;
import java.util.List;

public class TaskFour implements Runnable {
    private final List<Match> matchList;

    public TaskFour(List<Match> matchList) {
        this.matchList = matchList;
    }

    @Override
    public void run() {
        matchList.stream()
                .max((match1, match2) -> {
                    int homeGoals1 = Integer.parseInt(match1.getHome_score()) + Integer.parseInt(match1.getAway_score());
                    int awayGoals2 = Integer.parseInt(match2.getHome_score()) + Integer.parseInt(match2.getAway_score());
                    return Integer.compare(homeGoals1, awayGoals2);
                })
                .ifPresentOrElse(
                        match -> {
                            System.out.println("Match with the highest number of goals:");
                            System.out.println(match);
                        },
                        () -> System.out.println("No matches found.")
                );

    }
}
