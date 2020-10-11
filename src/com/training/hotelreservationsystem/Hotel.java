package com.training.hotelreservationsystem;

import java.util.Scanner;

public class Hotel {
    String HotelName;
    double rate;

    public Hotel(String hotelName, double rate) {
        HotelName = hotelName;
        this.rate = rate;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

}
