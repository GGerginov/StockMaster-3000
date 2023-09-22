package org.example;

import org.example.utill.StockGenerator;

public class Main {
    public static void main(String[] args) {

        StockGenerator.generateRandomStocks().forEach(System.out::println);



    }
}