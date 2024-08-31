package io;


import model.Match;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Alan.Ryan
 */
public class FileIO {

    static ArrayList<Match> nameList = new ArrayList();

    public static List<Match> readFile(String file) {

        Path p = Paths.get(file);
        List<String> lines = null;
        try {
            lines = Files.readAllLines(p);
            lines.remove(0);//remove the headers
        } catch (IOException ex) {
            System.out.println(ex);
        }

        for (String line : lines) {
            nameList.add(parseLine(line));
        }

        return nameList;

    }

    private static Match parseLine(String line) {
        String year;
        String country;
        String city;
        String stage;
        String home_team;
        String away_team;
        String home_score;
        String away_score;
        String outcome;
        String win_conditions;
        String winning_team;
        String losing_team;
        Date date = null;

        StringTokenizer st = new StringTokenizer(line);

        while (st.hasMoreElements()) {

            year = st.nextToken();
            country = st.nextToken();
            city = st.nextToken();
            stage  = st.nextToken();
            home_team  = st.nextToken();
            away_team = st.nextToken();
            home_score  = st.nextToken();
            away_score  = st.nextToken();
            outcome  = st.nextToken();
            win_conditions  = st.nextToken();
            winning_team  = st.nextToken();
            losing_team  = st.nextToken();
                        
            try {
                date  = new SimpleDateFormat("dd/MM/yyyy").parse(st.nextToken());
            } catch (ParseException ex) {
                System.out.println(year + city + home_team);
                System.out.println(">" + ex);
            }
            

            return new Match(year, country, city, stage, home_team, away_team, home_score, away_score, outcome, win_conditions, winning_team, losing_team, date);
        }//end while

        return null; //shouldn't get here
    }

}
