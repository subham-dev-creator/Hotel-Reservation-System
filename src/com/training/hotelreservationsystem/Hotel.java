package com.training.hotelreservationsystem;

public class Hotel {
    String HotelName;
    double weekdayRate;
    double weekendRate;
    int rating;
    double specialWeekdayRate;
    double specialWeekendRate;


    public double getWeekendRate() {
        return weekendRate;
    }

    public void setWeekendRate(double weekendRate) {
        this.weekendRate = weekendRate;
    }

    public Hotel(String hotelName, double weekdayRate, double weekendRate, int rating, double specialWeekdayRate, double getSpecialWeekendRate) {
        HotelName = hotelName;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.rating = rating;
        this.specialWeekdayRate = specialWeekdayRate;
        this.specialWeekendRate = getSpecialWeekendRate;
    }

    public double getSpecialWeekdayRate() {
        return specialWeekdayRate;
    }

    public void setSpecialWeekdayRate(double specialWeekdayRate) {
        this.specialWeekdayRate = specialWeekdayRate;
    }

    public double getSpecialWeekendRate() {
        return specialWeekendRate;
    }

    public void setSpecialWeekendRate(double specialWeekendRate) {
        this.specialWeekendRate = specialWeekendRate;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
