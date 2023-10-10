package com.test.flipcar.repositories;

import com.test.flipcar.beans.City;

import java.util.HashMap;
import java.util.Map;

public class CityRepository {
    private Map<String, City> cityMap;
    private static CityRepository instance;

    private CityRepository() {
        this.cityMap = new HashMap<>();
    }

    public static CityRepository getInstance() {
        if (instance == null) {
            instance = new CityRepository();
        }
        return instance;
    }

    public City save(City city) {
        cityMap.put(city.getId(), city);
        return city;
    }

    public City findCityById(String cityId) {
        return cityMap.get(cityId);
    }
}
