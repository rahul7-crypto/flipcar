package com.test.flipcar.services;

import com.test.flipcar.beans.Car;
import com.test.flipcar.beans.Vehicle;
import com.test.flipcar.enums.CarType;
import com.test.flipcar.enums.VehicleType;

import java.util.List;

public interface IVehicleService {
    Vehicle createCar(String licenseNumber, double defaultRatePerHour, CarType carType);
    Vehicle createBike(String licenseNumber, double defaultRatePerHour);
    List<Vehicle> findByVehicleType(VehicleType vehicleType);
    List<Car> findByCarType(CarType carType);
}
