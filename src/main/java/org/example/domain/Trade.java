package org.example.domain;

import java.util.Date;

/**
 * The {@code Trade} class represents a trading operation with profit, start date, and exit date.
 *
 * <p>Instances of this class are used to store and manipulate information about trades,
 * including the profit gained, the start date, and the exit date.
 *
 * @since 1.0
 */
public class Trade {

    private Integer profit;

    private Date startDate;

    private Date exitDate;

    /**
     * Constructs a new {@code Trade} object with the specified profit, start date, and exit date.
     *
     * @param profit    The profit gained from the trade.
     * @param startDate The start date of the trade.
     * @param exitDate  The exit date of the trade.
     */
    public Trade(Integer profit, Date startDate, Date exitDate) {
        this.profit = profit;
        this.startDate = startDate;
        this.exitDate = exitDate;
    }

    /**
     * Retrieves the profit gained from the trade.
     *
     * @return The profit gained.
     */
    public Integer getProfit() {
        return profit;
    }

    /**
     * Retrieves the start date of the trade.
     *
     * @return The start date of the trade.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Retrieves the exit date of the trade.
     *
     * @return The exit date of the trade.
     */
    public Date getExitDate() {
        return exitDate;
    }

    /**
     * Updates the current trade if the provided stock pair results in a better profit.
     *
     * <p>If the profit gained from the provided stock pair is greater than the current trade's profit,
     * this method updates the current trade's profit, start date, and exit date to match the provided values.
     *
     * @param minStock     The stock at the buy position.
     * @param currentStock The stock at the sell position.
     */
    public void updateIfBetter(Stock minStock, Stock currentStock) {

        int otherProfit = currentStock.getPrice() - minStock.getPrice();
        if (otherProfit > this.profit) {
            this.profit = otherProfit;
            this.startDate = minStock.getDate();
            this.exitDate = currentStock.getDate();
        }
    }

    /**
     * Returns a string representation of the {@code Trade} object.
     *
     * @return A string containing the profit, start date, and exit date of the trade.
     */
    @Override
    public String toString() {
        return "Trade{" +
                "profit=" + profit +
                ", startDate=" + startDate +
                ", exitDate=" + exitDate +
                '}';
    }
}
