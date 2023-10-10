package com.test.flipcar.services.impl;

import com.test.flipcar.beans.Booking;
import com.test.flipcar.beans.Branch;
import com.test.flipcar.beans.Car;
import com.test.flipcar.beans.Vehicle;
import com.test.flipcar.enums.CarType;
import com.test.flipcar.enums.VehicleType;
import com.test.flipcar.repositories.BookingRepository;
import com.test.flipcar.repositories.BranchRepository;
import com.test.flipcar.services.IBranchService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class BranchService implements IBranchService {

    private static BranchService instance;
    private BranchService() {}

    public static BranchService getInstance() {
        if (instance == null) {
            instance = new BranchService();
        }
        return instance;
    }

    @Override
    public Branch createBranch(String name, String cityId) {
        Branch branch = new Branch(name, cityId);
        return BranchRepository.getInstance().save(branch);
    }

    @Override
    public void addVehicles(String branchId, List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            BranchRepository.getInstance().addVehicle(branchId, vehicle);
        }
    }

    @Override
    public void addVehicle(String branchId, Vehicle vehicle) {
        BranchRepository.getInstance().addVehicle(branchId, vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles(String branchId) {
        return BranchRepository.getInstance().findBranchVehicles(branchId);
    }

    @Override
    public List<Vehicle> getAllVehicles(String branchId, VehicleType vehicleType) {
        List<Vehicle> targetedVehicles = new ArrayList<>();
        List<Vehicle> vehicles = getAllVehicles(branchId);
        for (Vehicle vehicle : vehicles) {
            if (vehicleType.equals(vehicle.getVehicleType())) {
                targetedVehicles.add(vehicle);
            }
        }
        return targetedVehicles;
    }

    @Override
    public List<Vehicle> getAvailableVehicles(String branchId, long fromTime, long toTime) {
        List<Vehicle> availableVehicles = new ArrayList<>();

        List<Vehicle> vehicles = getAllVehicles(branchId);
        for (Vehicle vehicle : vehicles) {
            List<Booking> bookings = BookingService.getInstance().fetchBookingByVehicleId(vehicle.getLicenseNumber());
            if (!isBookingPresentForInterval(bookings, fromTime, toTime)) {
                availableVehicles.add(vehicle);
            }
        }

        return availableVehicles;
    }

    @Override
    public Vehicle rentVehicle(String cityId, VehicleType vehicleType, long fromTime, long toTime) {
        List<Branch> branches = BranchRepository.getInstance().findBranches(cityId);
        PriorityQueue<Map.Entry<Vehicle, Double>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue().compareTo(e2.getValue()));

        for (Branch branch : branches) {
            List<Vehicle> vehicles = getAllVehicles(branch.getId(), vehicleType);
            for (Vehicle vehicle : vehicles) {
                List<Booking> bookings = BookingService.getInstance().fetchBookingByVehicleId(vehicle.getLicenseNumber());
                if (!isBookingPresentForInterval(bookings, fromTime, toTime)) {
                    minHeap.add(Map.entry(vehicle, vehicle.getDefaultRatePerHour()));
                }
            }
        }

        if (minHeap.isEmpty()) {
            return null;
        }
        Vehicle toBeBooked = minHeap.peek().getKey();
        BookingService.getInstance().createBooking(toBeBooked.getLicenseNumber(), fromTime, toTime);
        return toBeBooked;
    }

    @Override
    public Vehicle rentVehicle(String cityId, VehicleType vehicleType, CarType carType, long fromTime, long toTime) {
        List<Branch> branches = BranchRepository.getInstance().findBranches(cityId);
        PriorityQueue<Map.Entry<Vehicle, Double>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue().compareTo(e2.getValue()));

        for (Branch branch : branches) {
            List<Vehicle> vehicles = getAllVehicles(branch.getId(), vehicleType);
            for (Vehicle vehicle : vehicles) {
                if (vehicle instanceof Car) {
                    Car car = (Car) vehicle;
                    if (carType.equals(car.getCarType())) {
                        List<Booking> bookings = BookingService.getInstance().fetchBookingByVehicleId(car.getLicenseNumber());
                        if (!isBookingPresentForInterval(bookings, fromTime, toTime)) {
                            minHeap.add(Map.entry(vehicle, vehicle.getDefaultRatePerHour()));
                        }
                    }
                }
            }
        }

        if (minHeap.isEmpty()) {
            return null;
        }
        Vehicle toBeBooked = minHeap.peek().getKey();
        BookingService.getInstance().createBooking(toBeBooked.getLicenseNumber(), fromTime, toTime);
        return toBeBooked;
    }

    private boolean isBookingPresentForInterval(List<Booking> bookings, long fromTime, long toTime) {
        for (Booking booking : bookings) {
            if (booking.getFromTime() == fromTime && booking.getToTime() == toTime) {
                return true;
            }
        }
        return false;
    }

}
