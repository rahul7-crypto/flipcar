package com.test.flipcar.beans;

import com.test.flipcar.enums.CarType;

public class HatchBack extends Car {
    public HatchBack(String licenseNumber, double defaultPrice) {
        super(licenseNumber, defaultPrice, CarType.HATCH_BACK);
    }
}
