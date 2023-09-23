package org.example.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TradeTest {

    private Trade trade;
    private Stock minStock;
    private Stock currentStock;

    @BeforeEach
    public void setUp() {
        trade = new Trade(100, new Date(), new Date());
        minStock = new Stock(new Date(), 50);
        currentStock = new Stock(new Date(), 150);
    }

    @Test
    void testUpdateIfBetterWhenOtherProfitIsGreater() {

        minStock = new Stock(new Date(), 20);
        currentStock = new Stock(new Date(), 150);

        trade.updateIfBetter(minStock, currentStock);

        assertEquals(130, trade.getProfit());
        assertEquals(minStock.getDate(), trade.getStartDate());
        assertEquals(currentStock.getDate(), trade.getExitDate());
    }

    @Test
    void testUpdateIfBetterWhenOtherProfitIsLessOrEqual() {
        minStock = new Stock(new Date(), 100);
        currentStock = new Stock(new Date(), 150);

        trade.updateIfBetter(minStock, currentStock);

        assertEquals(100, trade.getProfit());
        assertEquals(trade.getStartDate(), trade.getStartDate());
        assertEquals(trade.getExitDate(), trade.getExitDate());
    }

    @Test
    void testUpdateIfBetterWhenOtherProfitIsLess() {
        minStock = new Stock(new Date(), 100);
        currentStock = new Stock(new Date(), 150);

        trade.updateIfBetter(minStock, currentStock);

        assertEquals(100, trade.getProfit());
    }

    @Test
    void testToStringWhenProfitStartDateAndExitDateAreSpecificValues() {
        // Arrange
        Integer profit = 200;
        Date startDate = new Date();
        Date exitDate = new Date();
        Trade trade = new Trade(profit, startDate, exitDate);

        // Act
        String result = trade.toString();

        // Assert
        String expected = "Trade{" +
                "profit=" + profit +
                ", startDate=" + startDate +
                ", exitDate=" + exitDate +
                '}';
        assertEquals(expected, result);
    }
}