package concurrency;

import model.Match;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class Task3 implements Callable<String> {
    private final List<Match> matchList;
    private final String nation;

    public Task3(List<Match> matchList, String nation) {
        this.matchList = matchList;
        this.nation = nation;
    }

    @Override
    public String call() throws Exception {

        List<Match> filterMatchList = matchList.stream()
                .filter(match -> match.getHome_team().equalsIgnoreCase(nation) || match.getAway_team().equalsIgnoreCase(nation))
                .sorted(Comparator.comparing(Match::getDate).reversed())
                .limit(5)
                .toList();

        return String.format("Last 5 matches played by %s are: %s", nation, filterMatchList);
    }

}

