package com.test.flipcar.services;

import com.test.flipcar.beans.Branch;
import com.test.flipcar.beans.Vehicle;
import com.test.flipcar.enums.CarType;
import com.test.flipcar.enums.VehicleType;

import java.util.List;

public interface IBranchService {
    Branch createBranch(String name, String cityId);
    void addVehicles(String branchId, List<Vehicle> vehicles);
    void addVehicle(String branchId, Vehicle vehicle);
    List<Vehicle> getAllVehicles(String branchId);
    List<Vehicle> getAllVehicles(String branchId, VehicleType vehicleType);
    List<Vehicle> getAvailableVehicles(String branchId, long fromTime, long toTime);
    Vehicle rentVehicle(String cityId, VehicleType vehicleType, long fromTime, long toTime);
    Vehicle rentVehicle(String cityId, VehicleType vehicleType, CarType carType, long fromTime, long toTime);
}
