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

    public static void main(String[] args) {
        Scanner SCANNEROBJ = new Scanner(System.in);
        System.out.println("Enter the Hotel name and rates");
        String name =SCANNEROBJ.next();
        double rate = SCANNEROBJ.nextInt();

        Hotel hotel1 = new Hotel(name,rate);
        System.out.println("Hotel " + hotel1.getHotelName() + " has rate " + hotel1.getRate());
    }
}
