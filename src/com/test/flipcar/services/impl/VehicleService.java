package com.test.flipcar.services.impl;

import com.test.flipcar.beans.Car;
import com.test.flipcar.beans.Vehicle;
import com.test.flipcar.enums.CarType;
import com.test.flipcar.enums.VehicleType;
import com.test.flipcar.factories.VehicleFactory;
import com.test.flipcar.repositories.VehicleRepository;
import com.test.flipcar.services.IVehicleService;

import java.util.List;

public class VehicleService implements IVehicleService {

    private static VehicleService instance;

    private VehicleService() {}

    public static VehicleService getInstance() {
        if (instance == null) {
            instance = new VehicleService();
        }
        return instance;
    }

    @Override
    public Vehicle createCar(String licenseNumber, double defaultRatePerHour, CarType carType) {
        Vehicle vehicle = VehicleFactory.createVehicle(licenseNumber, VehicleType.CAR, carType, defaultRatePerHour);
        return VehicleRepository.getInstance().save(vehicle);
    }

    @Override
    public Vehicle createBike(String licenseNumber, double defaultRatePerHour) {
        Vehicle vehicle = VehicleFactory.createVehicle(licenseNumber, VehicleType.BIKE, null, defaultRatePerHour);
        return VehicleRepository.getInstance().save(vehicle);
    }

    @Override
    public List<Vehicle> findByVehicleType(VehicleType vehicleType) {
        return VehicleRepository.getInstance().findByVehicleType(vehicleType);
    }

    @Override
    public List<Car> findByCarType(CarType carType) {
        return VehicleRepository.getInstance().findByCarType(carType);
    }
}
