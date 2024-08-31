package model;

import java.util.Date;

/**
 *
 * @author Alan.Ryan
 */
public class Match {
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
    Date date;


    public Match(String year, String country, String city, String stage, String home_team, String away_team, String home_score, String away_score, String outcome, String win_conditions, String winning_team, String losing_team, Date date) {
        this.year = year;
        this.country = country;
        this.city = city;
        this.stage = stage;
        this.home_team = home_team;
        this.away_team = away_team;
        this.home_score = home_score;
        this.away_score = away_score;
        this.outcome = outcome;
        this.win_conditions = win_conditions;
        this.winning_team = winning_team;
        this.losing_team = losing_team;
        this.date = date;
        
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getHome_team() {
        return home_team;
    }

    public void setHome_team(String home_team) {
        this.home_team = home_team;
    }

    public String getAway_team() {
        return away_team;
    }

    public void setAway_team(String away_team) {
        this.away_team = away_team;
    }

    public String getHome_score() {
        return home_score;
    }

    public void setHome_score(String home_score) {
        this.home_score = home_score;
    }

    public String getAway_score() {
        return away_score;
    }

    public void setAway_score(String away_score) {
        this.away_score = away_score;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getWin_conditions() {
        return win_conditions;
    }

    public void setWin_conditions(String win_conditions) {
        this.win_conditions = win_conditions;
    }

    public String getWinning_team() {
        return winning_team;
    }

    public void setWinning_team(String winning_team) {
        this.winning_team = winning_team;
    }

    public String getLosing_team() {
        return losing_team;
    }

    public void setLosing_team(String losing_team) {
        this.losing_team = losing_team;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Match{" + "year=" + year + ", country=" + country + ", city=" + city + ", stage=" + stage + ", home_team=" + home_team + ", away_team=" + away_team + ", home_score=" + home_score + ", away_score=" + away_score + ", outcome=" + outcome + ", win_conditions=" + win_conditions + ", winning_team=" + winning_team + ", losing_team=" + losing_team + ", date=" + date + '}';
    }

   
    
    
    

}
