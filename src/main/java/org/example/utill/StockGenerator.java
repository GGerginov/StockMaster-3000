package org.example.utill;

import org.example.domain.Stock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * The {@code StockGenerator} class provides utility methods for generating random and predefined stock data.
 * This class can be used to create lists of random or predefined stock objects.
 *
 * @since 1.0
 */
public class StockGenerator {

    private static final Random RANDOM = new Random();
    private static final int MAX_PRICE = 100;
    private static final int NUM_STOCKS_TO_GENERATE = 10;

    /**
     * Private constructor to prevent instantiation of the utility class.
     * Throws an {@code IllegalStateException} if called.
     */
    private StockGenerator() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Generates a random date within the current time range.
     *
     * @return A randomly generated date.
     */
    private static Date generateRandomDate() {
        long currentTimeMillis = System.currentTimeMillis();
        long randomTime = (long) (Math.random() * currentTimeMillis);
        return new Date(randomTime);
    }

    /**
     * Generates a random stock with a random date and price.
     *
     * @return A randomly generated stock.
     */
    private static Stock generateRandomStock() {
        Date date = generateRandomDate();
        int price = RANDOM.nextInt(MAX_PRICE + 1);
        return new Stock(date, price);
    }

    /**
     * Generates a list of random stock objects.
     *
     * @return A list of randomly generated stock objects.
     */
    public static List<Stock> generateRandomStocks() {
        List<Stock> stocks = new ArrayList<>();
        for (int i = 0; i < NUM_STOCKS_TO_GENERATE; i++) {
            stocks.add(generateRandomStock());
        }
        return stocks;
    }

    /**
     * Generates a list of predefined stock objects.
     *
     * @return A list of predefined stock objects.
     */
    public static List<Stock> generatePredefinedStocks() {
        List<Stock> stocks = new ArrayList<>();

        stocks.add(new Stock(new Date(1632313200000L), 50)); // Example stock 1
        stocks.add(new Stock(new Date(1632399600000L), 60)); // Example stock 2
        stocks.add(new Stock(new Date(1632486000000L), 55)); // Example stock 3

        return stocks;
    }

}

