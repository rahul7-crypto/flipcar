package com.test.flipcar.repositories;

import com.test.flipcar.beans.Booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingRepository {
    private Map<String, List<Booking>> vehicleBookingsMap;

    private static BookingRepository instance;
    private BookingRepository(){
        this.vehicleBookingsMap = new HashMap<>();
    }

    public static BookingRepository getInstance() {
        if (instance == null) {
            instance = new BookingRepository();
        }
        return instance;
    }

    public Booking save(Booking booking) {
        vehicleBookingsMap.putIfAbsent(booking.getVehicleId(), new ArrayList<>());
        vehicleBookingsMap.get(booking.getVehicleId()).add(booking);
        return booking;
    }

    public List<Booking> findByVehicleId(String vehicleId) {
        return vehicleBookingsMap.getOrDefault(vehicleId, new ArrayList<>());
    }
}
