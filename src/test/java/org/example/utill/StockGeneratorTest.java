package org.example.utill;

import org.example.domain.Stock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StockGeneratorTest {

    private Stock stock;

    private static final int MAX_PRICE = 100;

    @BeforeEach
    void setUp() {
        Method generateRandomStockMethod;
        try {
            generateRandomStockMethod = StockGenerator.class.getDeclaredMethod("generateRandomStock");

            generateRandomStockMethod.setAccessible(true);

            this.stock = (Stock) generateRandomStockMethod.invoke(null);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        generateRandomStockMethod.setAccessible(true);
    }


    @Test
    void testGeneratePredefinedStocksWhenCalledThenReturnsPredefinedStocks() {
        List<Stock> expectedStocks = Arrays.asList(
                new Stock(new Date(1632313200000L), 50),
                new Stock(new Date(1632399600000L), 60),
                new Stock(new Date(1632486000000L), 55)
        );

        List<Stock> actualStocks = StockGenerator.generatePredefinedStocks();

        assertEquals(expectedStocks.size(), actualStocks.size());
        for (int i = 0; i < expectedStocks.size(); i++) {
            assertEquals(expectedStocks.get(i).getDate(), actualStocks.get(i).getDate());
            assertEquals(expectedStocks.get(i).getPrice(), actualStocks.get(i).getPrice());
        }
    }

    @Test
    void testGenerateRandomStockWhenCalledThenReturnsValidStock() {

        assertNotNull(this.stock);
        assertNotNull(this.stock.getDate());
        assertNotNull(this.stock.getPrice());
        assertTrue(this.stock.getPrice() >= 0);
        assertTrue(this.stock.getPrice() <= MAX_PRICE);
    }

    @Test
    void testGenerateRandomStockWhenCalledThenReturnsStockWithPastDate() {

        Date currentDate = new Date();

        assertNotNull(this.stock.getDate());
        assertTrue(this.stock.getDate().before(currentDate));
    }

    @Test
    void testGenerateRandomDateReturnsValidDate() {
        Date currentDate = new Date();

        List<Stock> stocks = StockGenerator.generateRandomStocks();

        for (Stock stock : stocks) {
            assertNotNull(stock.getDate());
            assertTrue(stock.getDate().before(currentDate));
        }
    }

    @Test
    void testGenerateRandomDateReturnsUniqueStocks() {

        List<Stock> stocks1 = StockGenerator.generateRandomStocks();
        List<Stock> stocks2 = StockGenerator.generateRandomStocks();

        assertNotEquals(stocks1, stocks2);
    }

    @Test
    void testGenerateRandomStockPriceInRange() {

        assertNotNull(this.stock.getPrice());
        assertTrue(this.stock.getPrice() >= 0);
        assertTrue(this.stock.getPrice() <= MAX_PRICE);
    }
}