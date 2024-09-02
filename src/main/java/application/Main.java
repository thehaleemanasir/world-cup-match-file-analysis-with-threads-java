package application;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import concurrency.TaskFour;
import concurrency.TaskOne;
import concurrency.TaskThree;
import concurrency.TaskTwo;
import io.FileIO;
import model.Match;

import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

/**
 *
 * @author Alan.Ryan
 */
public class Main {
    
    static String[] nations = {"Algeria", "Angola", "Argentina", "Australia", "Austria", "Belgium", "Bolivia", "Bosnia-and-Herzegovina",
        "Brazil", "Bulgaria", "Cameroon", "Canada", "Chile", "China", "Colombia", "Costa-Rica", "Croatia",
        "Cuba", "Czechoslovakia", "Czech-Republic", "Denmark", "East-Germany", "Ecuador", "Egypt", "El-Salvador",
        "England", "France", "FR-Yugoslavia", "Germany", "Ghana", "Greece", "Haiti", "Honduras", "Hungary", "Iceland",
        "Iran", "Iraq", "Israel", "Italy", "Ivory-Coast", "Jamaica", "Japan", "Mexico", "Morocco", "Netherlands", "New-Zealand", "Nigeria",
        "Northern-Ireland", "North-Korea", "Norway", "Panama", "Paraguay", "Peru", "Poland", "Portugal", "Republic-of-Ireland",
        "Romania", "Russia", "Saudi-Arabia", "Scotland", "Senegal", "Serbia", "Slovakia", "Slovenia", "South-Africa", "South-Korea",
        "Spain", "Sweden", "Switzerland", "Togo", "Trinidad-and-Tobago", "Tunisia", "Turkey", "Ukraine", "United-Arab-Emirates",
        "Uruguay", "USA", "USSR", "West-Germany", "Yugoslavia", "Zaire"
    };
    
    public static void main(String[] args) throws ParseException, ExecutionException, InterruptedException {
       // List<Match> listy = FileIO.readFile("fifawc.txt");
       // listy.forEach(System.out::println)  ;

        String filePath = "./fifawc.txt";
        var matchList = FileIO.readFile(filePath);
        double matchCount = matchList.size();
        var message = "Found %s Match".formatted(matchCount);
        System.out.println(message);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(7);

        Future<String> task1Future = executorService.submit(new TaskOne(matchList, matchList.get(0).getDate(), matchList.get(matchList.size()-1).getDate()));
        executorService.scheduleWithFixedDelay(new TaskTwo(nations), 3, 2L, java.util.concurrent.TimeUnit.SECONDS);
        Future<List<Match>> task3Future = executorService.submit(new TaskThree(matchList, "Germany"));
        Future<List<Match>> task4Future = executorService.submit(new TaskFour(matchList, "Switzerland"));


        System.out.println(task1Future.get());
        System.out.println(task3Future.get());
        System.out.println(task4Future.get());

        executorService.shutdown();







    }
}
