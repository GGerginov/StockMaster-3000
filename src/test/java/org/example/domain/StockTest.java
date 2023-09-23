package org.example.domain;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StockTest {

    @Test
    void testUpdateIfLowerWhenLowerPricedStockThenUpdate() {
        Date date1 = new Date();
        Date date2 = new Date();
        Stock higherPricedStock = new Stock(date1, 200);
        Stock lowerPricedStock = new Stock(date2, 100);

        higherPricedStock.updateIfLower(lowerPricedStock);

        assertEquals(date2, higherPricedStock.getDate());
        assertEquals(100, higherPricedStock.getPrice());
    }

    @Test
    void testUpdateIfLowerWhenSamePricedStockThenNoUpdate() {
        Date date1 = new Date();
        Date date2 = new Date();
        Stock stock1 = new Stock(date1, 200);
        Stock stock2 = new Stock(date2, 200);

        stock1.updateIfLower(stock2);

        assertEquals(date1, stock1.getDate());
        assertEquals(200, stock1.getPrice());
    }

    @Test
    void testGetDateWhenCalledThenReturnDate() {
        Date date = new Date();
        Stock stock = new Stock(date, 200);

        Date returnedDate = stock.getDate();

        assertEquals(date, returnedDate);
    }

    @Test
    void testGetPriceWhenCalledThenReturnPrice() {
        Stock stock = new Stock(new Date(), 200);

        Integer returnedPrice = stock.getPrice();

        assertEquals(200, returnedPrice);
    }

    @Test
    void testConstructor() {
        Date date = new Date();

        Stock stock = new Stock(date, 200);

        assertEquals(200, stock.getPrice());
        assertEquals(date, stock.getDate());
    }

    @Test
    void testToStringReturnsCorrectFormat() {
        Date date = new Date();
        Stock stock = new Stock(date, 200);
        String expectedString = "Stock{date=" + date + ", price=200}";

        String returnedString = stock.toString();

        assertEquals(expectedString, returnedString);
    }
}