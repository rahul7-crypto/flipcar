package com.test.flipcar.beans;

import com.test.flipcar.enums.CarType;

public class Suv extends Car {
    public Suv(String licenseNumber, double defaultPrice) {
        super(licenseNumber, defaultPrice, CarType.SUV);
    }
}
