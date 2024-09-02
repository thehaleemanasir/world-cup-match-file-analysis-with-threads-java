package application;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import concurrency.Task4Runnable;
import concurrency.Task1Callable;
import concurrency.Task3Callable;
import concurrency.Task2Runnable;
import io.FileIO;

import java.text.ParseException;
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

        String filePath = "./fifawc.csv";
        var matchList = FileIO.readFile(filePath);
        double matchCount = matchList.size();
        var message = "Found %s Match".formatted(matchCount);
        System.out.println(message);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(7);

        String startDate = "01/01/1950";
        String endDate = "01/01/1955";
        Future<String> task1Future = executorService.submit(new Task1Callable(matchList, startDate, endDate));
        executorService.scheduleWithFixedDelay(new Task2Runnable(nations, matchList), 3, 2L, java.util.concurrent.TimeUnit.SECONDS);
        var task3 = new Task3Callable(matchList, "Argentina");
        Future<String> task3Future = executorService.submit(task3);
        executorService.submit(new Task4Runnable(matchList));


        System.out.println(task1Future.get());
        System.out.println(task3Future.get());

    }
}
