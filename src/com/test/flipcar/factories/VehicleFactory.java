package com.test.flipcar.factories;

import com.test.flipcar.beans.*;
import com.test.flipcar.enums.CarType;
import com.test.flipcar.enums.VehicleType;

public class VehicleFactory {

    public static Vehicle createVehicle(String licenseNumber, VehicleType vehicleType, CarType carType, double defaultRatePerHour) {
        switch (vehicleType) {
            case BIKE:
                return new Bike(licenseNumber, defaultRatePerHour);
            case CAR:
                return createCar(licenseNumber, carType, defaultRatePerHour);
        }
        return null;
    }

    private static Vehicle createCar(String licenseNumber, CarType carType, double defaultRatePerHour) {
        switch (carType) {
            case SUV:
                return new Suv(licenseNumber, defaultRatePerHour);
            case SEDAN:
                return new Sedan(licenseNumber, defaultRatePerHour);
            case HATCH_BACK:
                return new HatchBack(licenseNumber, defaultRatePerHour);
        }
        return null;
    }
}
