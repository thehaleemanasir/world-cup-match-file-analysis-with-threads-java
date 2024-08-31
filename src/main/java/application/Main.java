package application;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import io.FileIO;
import model.Match;

import java.util.List;

/**
 *
 * @author Alan.Ryan
 */
public class Main {
    
    String[] nations = {"Algeria", "Angola", "Argentina", "Australia", "Austria", "Belgium", "Bolivia", "Bosnia-and-Herzegovina",
        "Brazil", "Bulgaria", "Cameroon", "Canada", "Chile", "China", "Colombia", "Costa-Rica", "Croatia",
        "Cuba", "Czechoslovakia", "Czech-Republic", "Denmark", "East-Germany", "Ecuador", "Egypt", "El-Salvador",
        "England", "France", "FR-Yugoslavia", "Germany", "Ghana", "Greece", "Haiti", "Honduras", "Hungary", "Iceland",
        "Iran", "Iraq", "Israel", "Italy", "Ivory-Coast", "Jamaica", "Japan", "Mexico", "Morocco", "Netherlands", "New-Zealand", "Nigeria",
        "Northern-Ireland", "North-Korea", "Norway", "Panama", "Paraguay", "Peru", "Poland", "Portugal", "Republic-of-Ireland",
        "Romania", "Russia", "Saudi-Arabia", "Scotland", "Senegal", "Serbia", "Slovakia", "Slovenia", "South-Africa", "South-Korea",
        "Spain", "Sweden", "Switzerland", "Togo", "Trinidad-and-Tobago", "Tunisia", "Turkey", "Ukraine", "United-Arab-Emirates",
        "Uruguay", "USA", "USSR", "West-Germany", "Yugoslavia", "Zaire"
    };
    
    public static void main(String[] args) {
        List<Match> listy = FileIO.readFile("fifawc.txt");
        listy.forEach(System.out::println)  ;

    }
}
