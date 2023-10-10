package com.test.flipcar.beans;

import java.util.UUID;

public class Branch {
    private String id;
    private String name;
    private String cityId;

    public Branch(String name, String cityId) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.cityId = cityId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}
