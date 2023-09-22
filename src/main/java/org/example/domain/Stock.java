package org.example.domain;

import java.util.Date;

public class Stock {

    private Date date;

    private Integer price;

    public Stock(Date date, Integer price) {
        this.date = date;
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "date=" + date +
                ", price=" + price +
                '}';
    }
}
