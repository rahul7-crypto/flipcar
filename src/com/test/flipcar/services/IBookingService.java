package com.test.flipcar.services;

import com.test.flipcar.beans.Booking;

import java.util.List;

public interface IBookingService {
    Booking createBooking(String vehicleId, long fromTime, long toTime);
    List<Booking> fetchBookingByVehicleId(String vehicleId);
}
