package com.training.hotelreservationsystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem {
    final static Scanner SCANNEROBJ = new Scanner(System.in);
    private ArrayList<Hotel> hotelList = new ArrayList<>();

    // ADD NEW HOTEL IN RESERVATION SYSTEM
    public void addHotel(){
        System.out.println("Enter the Hotel name and rates");
        String name =SCANNEROBJ.next();

        double rate = SCANNEROBJ.nextDouble();
        Hotel tempHotel = new Hotel(name,rate);
        hotelList.add(tempHotel);
    }

    // Check Cheapest Price Between Given Days
    public void checkCheapestPrice(){
        System.out.println("Enter start date and end date int the format (yyyy-MM-dd),(yyyy-MM-dd)");
        String line=SCANNEROBJ.next();
        String[] input=line.split(",");

        LocalDate startDate = LocalDate.parse(input[0]);
        LocalDate endDate = LocalDate.parse(input[1]);

        int dateDifference=(int) ChronoUnit.DAYS.between(startDate, endDate);
        double cheapestRate=100000000;
        String cheapestHotel="";

        for(Hotel hotel : hotelList) {
            double rateForHotel=dateDifference*hotel.getRate();
            if(rateForHotel<cheapestRate) {
                cheapestRate=rateForHotel;
                cheapestHotel=hotel.getHotelName();
            }
        }
        if(cheapestRate!=100000000)
            System.out.println("Cheapest Hotel : \n"+cheapestHotel+", Total Rates: "+cheapestRate);
    }

    // DISPLAY ALL HOTELS WITH PRICES
    private void displayHotel() {
        int i=0;
        for (Hotel h: hotelList) {
            System.out.println(++i + ". Hotel " + h.getHotelName() + " Rate: " + h.getRate());
        }
    }

    public static void main(String[] args) {
        HotelReservationSystem hotelSystem = new HotelReservationSystem();
        System.out.println("Hotel Reservation System");

        int choice = 1;
        while (choice != 0) {
            System.out.println("Enter your choice \n 1.Add New Hotel \n 2.Display Hotel \n 3.Check Cheapest Prices");
            choice = SCANNEROBJ.nextInt();
            switch (choice) {
                case 1:
                    hotelSystem.addHotel();
                    break;
                case 2:
                    hotelSystem.displayHotel();
                    break;
                case 3:
                    hotelSystem.checkCheapestPrice();
                    break;
                default:
                    System.out.println("Invalid Input Please try again");
                    break;
            }
        }

    }
}
