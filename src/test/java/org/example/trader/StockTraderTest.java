package org.example.trader;

import org.example.domain.Stock;
import org.example.domain.Trade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StockTraderTest {

    @Test
    void testTradeWhenInputIsNullThenThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> StockTrader.trade(null));
    }

    @Test
    void testTradeWhenInputIsEmptyThenThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> StockTrader.trade(Collections.emptyList()));
    }

    @Test
    void testTradeWhenInputHasOneStockThenReturnsZeroProfitTrade() {
        Stock stock1 = new Stock(new Date(), 100);

        Trade bestTrade = StockTrader.trade(Collections.singletonList(stock1));

        Assertions.assertNotNull(bestTrade);
        Assertions.assertEquals(0, bestTrade.getProfit());
    }

    @Test
    void testTradeWhenInputHasMultipleStocksAndProfitableTradeThenReturnsBestTrade() {
        Stock stock1 = new Stock(new Date(), 100);
        Stock stock2 = new Stock(new Date(), 200);
        Stock stock3 = new Stock(new Date(), 150);
        Stock stock4 = new Stock(new Date(), 250);

        Trade bestTrade = StockTrader.trade(Arrays.asList(stock1, stock2, stock3, stock4));

        Assertions.assertNotNull(bestTrade);
        Assertions.assertEquals(150, bestTrade.getProfit());
    }

    @Test
    void testTradeWhenStocksNullThenThrowIllegalArgumentException() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> StockTrader.trade(null));
    }

    @Test
    void testTradeWhenStocksEmptyThenThrowIllegalArgumentException() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> StockTrader.trade(Collections.emptyList()));
    }

}