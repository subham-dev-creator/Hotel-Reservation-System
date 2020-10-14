package com.training.hotelreservationsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem {
    final static Scanner SCANNEROBJ = new Scanner(System.in);
    private ArrayList<Hotel> hotelList = new ArrayList<>();

    // ADD NEW HOTEL IN RESERVATION SYSTEM
    public void addHotel(){
        System.out.println("Enter the Hotel name ");
        String name =SCANNEROBJ.next();
        System.out.println("WeekDay Rate :");
        double weekdayRate = SCANNEROBJ.nextDouble();
        System.out.println("WeekEnd Rate :");
        double weekendRate = SCANNEROBJ.nextDouble();
        System.out.println("Enter the hotel rating from 1-5");
        int hotelRating = SCANNEROBJ.nextInt();
        System.out.println("Special WeekDay Rate :");
        double specialWeekdayRate = SCANNEROBJ.nextDouble();
        System.out.println("Special WeekEnd Rate :");
        double specialWeekendRate = SCANNEROBJ.nextDouble();

        Hotel tempHotel = new Hotel(name,weekdayRate,weekendRate,hotelRating,specialWeekdayRate,specialWeekendRate);
        hotelList.add(tempHotel);
    }

    // Check Cheapest Price Between Given Days
    public void checkCheapestPrice(){
        System.out.println("Enter start date in the format (yyyy-MM-dd)");
        String date1=SCANNEROBJ.next();
        System.out.println("Enter the end date in the format (yyyy-MM-dd)");
        String date2=SCANNEROBJ.next();

        int weekEndDays = 0, weekDays = 0;
        double minimumPrice = Integer.MAX_VALUE;

        LocalDate startDate = LocalDate.parse(date1);
        LocalDate endDate = LocalDate.parse(date2);

        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            int day = date.getDayOfWeek().getValue();
            if (day == 6 || day == 7) {
                weekEndDays++;
            } else
                weekDays++;
        }
        if (endDate.getDayOfWeek().getValue() == 6 || endDate.getDayOfWeek().getValue() == 7)
            weekEndDays++;
        else
            weekDays++;

        ArrayList<Hotel> cheapestHotel = new ArrayList<>();
        for (Hotel hotel : hotelList) {
            double currentHotelPrice = (hotel.getWeekdayRate() * weekDays) + (hotel.getWeekendRate() * weekEndDays);
            if (currentHotelPrice < minimumPrice) {
                minimumPrice = currentHotelPrice;
                cheapestHotel.clear();
                cheapestHotel.add(hotel);
            } else if (currentHotelPrice == minimumPrice && cheapestHotel.size() > 0 && hotel.getRating() > cheapestHotel.get(0).getRating()) {
                cheapestHotel.clear();
                cheapestHotel.add(hotel);
            } else if(currentHotelPrice == minimumPrice && cheapestHotel.size() > 0 && hotel.getRating() == cheapestHotel.get(0).getRating()){
                cheapestHotel.add(hotel);
            }
        }
        System.out.println("Cheapest Hotels :");
        for(Hotel printCheapestHotel : cheapestHotel) {
            System.out.println(printCheapestHotel.getHotelName() + "\nRating : " + printCheapestHotel.getRating() + "\nRate " + startDate + " to " + endDate +" : " );
        }
    }

    // DISPLAY ALL HOTELS WITH PRICES
    private void displayHotel() {
        int i=0;
        for (Hotel h: hotelList) {
            System.out.println(++i + ". Hotel " + h.getHotelName() + " Rating : " + h.getRating()  + " WeekDay Rate: " + h.getWeekdayRate() + " WeekEnd Rate : " + h.getWeekendRate());
        }
    }

    //
    public void checkBestRated(){
        System.out.println("Enter start date in the format (yyyy-MM-dd)");
        String date1=SCANNEROBJ.next();
        System.out.println("Enter the end date in the format (yyyy-MM-dd)");
        String date2=SCANNEROBJ.next();

        int weekEndDays = 0, weekDays = 0;
        double minimumPrice = Integer.MAX_VALUE;

        LocalDate startDate = LocalDate.parse(date1);
        LocalDate endDate = LocalDate.parse(date2);

        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            int day = date.getDayOfWeek().getValue();
            if (day == 6 || day == 7) {
                weekEndDays++;
            } else
                weekDays++;
        }

        String hotelName = "";
        int tempRating = 0;
        double cost = 0;
        for (Hotel hotelList : hotelList) {

            if (hotelList.getRating() > tempRating) {
                cost = (hotelList.getWeekdayRate() * weekDays) + (hotelList.getWeekendRate() * weekEndDays);
                hotelName = hotelList.getHotelName();
                tempRating = hotelList.getRating();
            }
        }
        System.out.println("Best Rated hotel is \n" + hotelName);
        System.out.println("Rating : " +tempRating);
        System.out.println("Total cost : " + cost);
    }

    public void findCheapestHotelForRewardedCustomers() {
        System.out.println("Enter start date in the format (yyyy-MM-dd)");
        String date1=SCANNEROBJ.next();
        System.out.println("Enter the end date in the format (yyyy-MM-dd)");
        String date2=SCANNEROBJ.next();
        LocalDate entryDate = LocalDate.parse(date1);
        LocalDate exitDate = LocalDate.parse(date2);

        int weekEndDays = 0, weekDays = 0;

        double minimumRate = Integer.MAX_VALUE;

        for (LocalDate date = entryDate; date.isBefore(exitDate); date = date.plusDays(1)) {
            int day = date.getDayOfWeek().getValue();
            if (day == 6 || day == 7) {
                weekEndDays++;
            } else
                weekDays++;
        }
        if (exitDate.getDayOfWeek().getValue() == 6 || exitDate.getDayOfWeek().getValue() == 7)
            weekEndDays++;
        else
            weekDays++;

        ArrayList<Hotel> cheapestHotel = new ArrayList<>();
        for (Hotel hotelList : hotelList) {
            double temp = (hotelList.getSpecialWeekdayRate() * weekDays) + (hotelList.getWeekendRate() * weekEndDays);
            if (temp < minimumRate) {
                minimumRate = temp;
                cheapestHotel.clear();
                cheapestHotel.add(hotelList);
            }
            else if(temp == minimumRate) {
                cheapestHotel.add(hotelList);
            }
        }
        int maxRating = 0;
        String hotelName = "";
        for(Hotel printCheapestHotel : cheapestHotel) {
            if(printCheapestHotel.getRating()>maxRating) {
                maxRating = printCheapestHotel.getRating();
                hotelName = printCheapestHotel.getHotelName();
            }
        }
        System.out.println("Cheapest Best Rated hotel for rewarded customer is \n" + hotelName);
        System.out.println("Rating : " +maxRating);
        System.out.println("Total cost : " + minimumRate);

    }
    public static void main(String[] args) {
        HotelReservationSystem hotelSystem = new HotelReservationSystem();
        System.out.println("Hotel Reservation System");

        int choice = 1;
        while (choice != 0) {
            System.out.println("Enter your choice \n 1.Add New Hotel \n 2.Display Hotel \n 3.Check Cheapest Prices " +
                    "\n 4.Check Best Rated Hotel \n 5.Check Cheapest Hotel For Rewared Customers");
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
                case 4:
                    hotelSystem.checkBestRated();
                case 5:
                    hotelSystem.findCheapestHotelForRewardedCustomers();
                default:
                    System.out.println("Invalid Input Please try again");
                    break;
            }
        }
    }
}
