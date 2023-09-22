package org.example.domain;

import java.util.Date;

public class Trade {

    private Integer profit;

    private Date startDate;

    private Date exitDate;

    public Trade(Integer profit, Date startDate, Date exitDate) {
        this.profit = profit;
        this.startDate = startDate;
        this.exitDate = exitDate;
    }

    public Integer getProfit() {
        return profit;
    }


    @Override
    public String toString() {
        return "Trade{" +
                "profit=" + profit +
                ", startDate=" + startDate +
                ", exitDate=" + exitDate +
                '}';
    }
}
