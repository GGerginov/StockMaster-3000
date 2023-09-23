package org.example.domain;

import java.util.Date;

/**
 * The {@code Stock} class represents a stock with a specific date and price.
 *
 * <p>Instances of this class are used to store and manipulate information about individual stocks.
 *
 * @since 1.0
 */
public class Stock {

    private Date date;

    private Integer price;

    /**
     * Constructs a new {@code Stock} object with the specified date and price.
     *
     * @param date  The date of the stock.
     * @param price The price of the stock.
     */
    public Stock(Date date, Integer price) {
        this.date = date;
        this.price = price;
    }
    /**
     * Retrieves the date of the stock.
     *
     * @return The date of the stock.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Retrieves the price of the stock.
     *
     * @return The price of the stock.
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * Updates the current stock if the provided stock has a lower price.
     *
     * <p>If the price of the provided stock is lower than the current stock's price,
     * this method updates the current stock's date and price to match the provided stock's values.
     *
     * @param currentStock The stock to compare with the current stock.
     */
    public void updateIfLower(Stock currentStock) {

        if (currentStock.getPrice() < this.price){
            this.date = currentStock.getDate();
            this.price = currentStock.getPrice();
        }

    }

    /**
     * Returns a string representation of the {@code Stock} object.
     *
     * @return A string containing the date and price of the stock.
     */
    @Override
    public String toString() {
        return "Stock{" +
                "date=" + date +
                ", price=" + price +
                '}';
    }
}
