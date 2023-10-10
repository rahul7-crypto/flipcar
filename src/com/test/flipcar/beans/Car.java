package com.test.flipcar.beans;

import com.test.flipcar.enums.CarType;
import com.test.flipcar.enums.VehicleType;

public abstract class Car extends Vehicle {
    private CarType carType;

    public Car(String licenseNumber, double defaultPrice, CarType carType) {
        super(licenseNumber, VehicleType.CAR, defaultPrice);
        this.carType = carType;
    }

    public CarType getCarType() {
        return carType;
    }
}
