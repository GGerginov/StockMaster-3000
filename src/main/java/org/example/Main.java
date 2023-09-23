package org.example;

import org.example.domain.Stock;
import org.example.domain.Trade;
import org.example.trader.StockTrader;
import org.example.utill.StockGenerator;

import java.util.List;

public class Main {
    public static void main(String[] args) {



        List<Stock> stocks = StockGenerator.generatePredefinedStocks();

        stocks.forEach(System.out::println);

        Trade bestTrade = StockTrader.
                trade(stocks);

        System.out.println(bestTrade);

    }
}