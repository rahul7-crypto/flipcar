package com.test.flipcar.beans;

import com.test.flipcar.enums.CarType;

public class Sedan extends Car {
    public Sedan(String licenseNumber, double defaultPrice) {
        super(licenseNumber, defaultPrice, CarType.SEDAN);
    }
}
