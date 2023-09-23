package org.example.trader;


import org.example.domain.Stock;
import org.example.domain.Trade;

import java.util.List;

/**
 * The {@code StockTrader} class provides utility methods for analyzing and trading stocks.
 * It includes a method to find the best trade that maximizes profit based on a list of stocks.
 *
 * <p>This class is a utility class and cannot be instantiated. All methods are static.
 *
 * @author G.Gerginov
 * @version 1.0
 * @since 1.0
 * */
public class StockTrader {

    /**
     * Private constructor to prevent instantiation of the utility class.
     *
     * @throws IllegalStateException if an attempt is made to instantiate this class.
     */
    private StockTrader() {
        throw new IllegalStateException("Utility class");
    }

    /**
     Calculates the best trade based on a list of stocks.
     The best trade is determined by finding the maximum profit that can be obtained
     by buying and selling stocks at different dates.

     @param stocks the list of stocks to analyze
     @return the Trade object representing the best trade, or null if no trade is possible
     @throws IllegalArgumentException if the stocks list is null or empty */
    public static Trade trade(List<Stock> stocks) {

        if (stocks == null || stocks.isEmpty()) {
            throw new IllegalArgumentException();
        }

        final Trade bestTrade = new Trade(0, null, null);

        final Stock minStock = stocks.get(0);

        stocks.stream()
                .skip(1)
                .forEach(currentStock -> {
                    bestTrade.updateIfBetter(minStock,currentStock);
                    minStock.updateIfLower(currentStock);
                });

        return bestTrade;
    }


}


