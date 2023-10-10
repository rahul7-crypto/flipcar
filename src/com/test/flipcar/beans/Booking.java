package com.test.flipcar.beans;

import java.util.UUID;

public class Booking {
    private String id;
    private String vehicleId;
    private long fromTime;
    private long toTime;

    public Booking(String vehicleId, long fromTime, long toTime) {
        this.id = UUID.randomUUID().toString();
        this.vehicleId = vehicleId;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public long getFromTime() {
        return fromTime;
    }

    public void setFromTime(long fromTime) {
        this.fromTime = fromTime;
    }

    public long getToTime() {
        return toTime;
    }

    public void setToTime(long toTime) {
        this.toTime = toTime;
    }
}
