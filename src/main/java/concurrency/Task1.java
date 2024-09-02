package concurrency;


import model.Match;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

public class Task1 implements Callable<String> {
    private final List<Match> matchList;
    private final Date startDate;
    private final Date endDate;

    public Task1(List<Match> matchList, String startDate, String endDate) throws ParseException {
        this.matchList = matchList;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.startDate = dateFormat.parse(startDate);
        this.endDate = dateFormat.parse(endDate);

    }


    @Override
    public String call() throws Exception {
        List<Match> filterMatchList = matchList.stream()
                .filter(match -> match.getDate().after(startDate)
                        && match.getDate().before(endDate))
                .toList();

        return String.format("Number of matches played between %s and %s is %d", startDate, endDate, filterMatchList.size());
    }

}
