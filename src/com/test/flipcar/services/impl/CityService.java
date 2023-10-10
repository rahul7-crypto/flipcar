package com.test.flipcar.services.impl;

import com.test.flipcar.beans.City;
import com.test.flipcar.repositories.CityRepository;
import com.test.flipcar.services.ICityService;

public class CityService implements ICityService {

    private static CityService instance;
    private CityService() {}

    public static CityService getInstance() {
        if (instance == null) {
            instance = new CityService();
        }
        return instance;
    }

    @Override
    public City createCity(String name) {
        City city = new City(name);
        return CityRepository.getInstance().save(city);
    }
}
