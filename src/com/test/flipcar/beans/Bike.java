package com.test.flipcar.beans;

import com.test.flipcar.enums.VehicleType;

public class Bike extends Vehicle {
    public Bike(String licenseNumber, double defaultPrice) {
        super(licenseNumber, VehicleType.BIKE, defaultPrice);
    }
}
