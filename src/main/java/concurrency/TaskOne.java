package concurrency;


import model.Match;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

public class TaskOne implements Callable<String>{
    private final List<Match> matchList;
    private final Date startDate;
    private final Date endDate;

    public TaskOne(List<Match> matchList, Date startDate, Date endDate) throws ParseException {
        this.matchList = matchList;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.startDate = dateFormat.parse(dateFormat.format(startDate));
        this.endDate = dateFormat.parse(dateFormat.format(endDate));

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
