package com.test.flipcar.services.impl;

import com.test.flipcar.beans.Booking;
import com.test.flipcar.repositories.BookingRepository;
import com.test.flipcar.services.IBookingService;

import java.util.List;

public class BookingService implements IBookingService {

    private static BookingService instance;
    private BookingService() {}

    public static BookingService getInstance() {
        if (instance == null) {
            instance = new BookingService();
        }
        return instance;
    }

    @Override
    public Booking createBooking(String vehicleId, long fromTime, long toTime) {
        Booking booking = new Booking(vehicleId, fromTime, toTime);
        return BookingRepository.getInstance().save(booking);
    }

    @Override
    public List<Booking> fetchBookingByVehicleId(String vehicleId) {
        return BookingRepository.getInstance().findByVehicleId(vehicleId);
    }
}
