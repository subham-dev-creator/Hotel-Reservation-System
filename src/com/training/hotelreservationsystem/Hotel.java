package com.training.hotelreservationsystem;

public class Hotel {
    String HotelName;
    double weekdayRate;
    double weekendRate;

    public double getWeekendRate() {
        return weekendRate;
    }

    public void setWeekendRate(double weekendRate) {
        this.weekendRate = weekendRate;
    }

    public Hotel(String hotelName, double weekdayRate, double weekendRate) {
        HotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public double getWeekdayRate() {
        return weekdayRate;
    }

    public void setWeekdayRate(double weekdayRate) {
        this.weekdayRate = weekdayRate;
    }

}
