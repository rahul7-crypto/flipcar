package com.test.flipcar.beans;

import com.test.flipcar.enums.VehicleType;

public abstract class Vehicle {
    private String licenseNumber;
    private VehicleType vehicleType;
    private double defaultRatePerHour;

    public Vehicle(String licenseNumber, VehicleType vehicleType, double defaultRatePerHour) {
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
        this.defaultRatePerHour = defaultRatePerHour;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getDefaultRatePerHour() {
        return defaultRatePerHour;
    }

    public void setDefaultRatePerHour(double defaultRatePerHour) {
        this.defaultRatePerHour = defaultRatePerHour;
    }
}
