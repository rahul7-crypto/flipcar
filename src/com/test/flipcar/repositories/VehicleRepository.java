package com.test.flipcar.repositories;

import com.test.flipcar.beans.Car;
import com.test.flipcar.beans.Sedan;
import com.test.flipcar.beans.Vehicle;
import com.test.flipcar.enums.CarType;
import com.test.flipcar.enums.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleRepository {

    private static VehicleRepository instance;
    private Map<String, Vehicle> licenseNumberVehicleMap;
    private Map<VehicleType, List<Vehicle>> vehicleTypeVehiclesMap;
    private Map<CarType, List<Car>> carTypeVehiclesMap;

    private VehicleRepository() {
        this.licenseNumberVehicleMap = new HashMap<>();
        this.vehicleTypeVehiclesMap = new HashMap<>();
        this.carTypeVehiclesMap = new HashMap<>();
        Vehicle vehicle = new Sedan("", 0);
    }

    public static VehicleRepository getInstance() {
        if (instance == null) {
            instance = new VehicleRepository();
        }
        return instance;
    }

    public Vehicle save(Vehicle vehicle) {
        licenseNumberVehicleMap.put(vehicle.getLicenseNumber(), vehicle);
        vehicleTypeVehiclesMap.putIfAbsent(vehicle.getVehicleType(), new ArrayList<>());
        vehicleTypeVehiclesMap.get(vehicle.getVehicleType()).add(vehicle);
        if (vehicle instanceof Car car) {
            carTypeVehiclesMap.putIfAbsent(car.getCarType(), new ArrayList<>());
            carTypeVehiclesMap.get(car.getCarType()).add(car);
        }
        return vehicle;
    }

    public List<Vehicle> findByVehicleType(VehicleType vehicleType) {
        return vehicleTypeVehiclesMap.getOrDefault(vehicleType, new ArrayList<>());
    }

    public List<Car> findByCarType(CarType carType) {
        return carTypeVehiclesMap.getOrDefault(carType, new ArrayList<>());
    }
}
