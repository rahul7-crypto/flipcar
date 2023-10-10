package com.test.flipcar;

import com.test.flipcar.beans.Branch;
import com.test.flipcar.beans.City;
import com.test.flipcar.beans.Vehicle;
import com.test.flipcar.enums.CarType;
import com.test.flipcar.enums.VehicleType;
import com.test.flipcar.services.impl.BookingService;
import com.test.flipcar.services.impl.BranchService;
import com.test.flipcar.services.impl.CityService;
import com.test.flipcar.services.impl.VehicleService;

import java.util.Arrays;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        CityService cityService = CityService.getInstance();
        BranchService branchService = BranchService.getInstance();
        VehicleService vehicleService = VehicleService.getInstance();
        BookingService bookingService = BookingService.getInstance();

        City bangalore = cityService.createCity("Bangalore");

        // Vehicles in gachibowli
        Vehicle suv111 = vehicleService.createCar("SUV111", 12.0, CarType.SUV);
        Vehicle sedan111 = vehicleService.createCar("SEDAN111", 10.0, CarType.SEDAN);
        Vehicle sedan112 = vehicleService.createCar("SEDAN112", 10.0, CarType.SEDAN);
        Vehicle sedan113 = vehicleService.createCar("SEDAN113", 10.0, CarType.SEDAN);
        Vehicle bike111 = vehicleService.createBike("BIKE111", 20.0);


        Branch gachibowliBranch = branchService.createBranch("gachibowli", bangalore.getId());
        branchService.addVehicles(gachibowliBranch.getId(), Arrays.asList(suv111, sedan111, sedan112, sedan113, bike111));
        branchService.addVehicle(gachibowliBranch.getId(), vehicleService.createCar("SEDAN114", 10.0, CarType.SEDAN));

        // Vehicles in kukatpally
        Vehicle sedan222 = vehicleService.createCar("SEDAN222", 11.0, CarType.SEDAN);
        Vehicle sedan223 = vehicleService.createCar("SEDAN223", 11.0, CarType.SEDAN);
        Vehicle sedan224 = vehicleService.createCar("SEDAN224", 11.0, CarType.SEDAN);
        Vehicle bike222 = vehicleService.createBike("BIKE222", 20.0);
        Vehicle bike223 = vehicleService.createBike("BIKE223", 20.0);
        Vehicle bike224 = vehicleService.createBike("BIKE224", 20.0);
        Vehicle hatchBack222 = vehicleService.createCar("HATCH_BACK222", 8.0, CarType.HATCH_BACK);
        Vehicle hatchBack223 = vehicleService.createCar("HATCH_BACK223", 8.0, CarType.HATCH_BACK);
        Vehicle hatchBack224 = vehicleService.createCar("HATCH_BACK224", 8.0, CarType.HATCH_BACK);

        Branch kukatpallyBranch = branchService.createBranch("kukatpally", bangalore.getId());
        branchService.addVehicles(kukatpallyBranch.getId(), Arrays.asList(sedan222, sedan223, sedan224, bike222, bike223, bike224, hatchBack222, hatchBack223, hatchBack224));

        // Vehicles in kukatpally
        Vehicle suv333 = vehicleService.createCar("SUV333", 11.0, CarType.SUV);

        Branch miyapurBranch = branchService.createBranch("miyapur", bangalore.getId());
        branchService.addVehicles(miyapurBranch.getId(), Arrays.asList(suv333));

        System.out.println(branchService.getAllVehicles(gachibowliBranch.getId()));

        branchService.rentVehicle(bangalore.getId(), VehicleType.CAR, CarType.SUV, 1697067000000l, 1697070600000l);
        branchService.rentVehicle(bangalore.getId(), VehicleType.CAR, CarType.SUV, 1697067000000l, 1697070600000l);

    }

    private static Branch createBranch(String name, City bangalore) {
        VehicleService vehicleService = VehicleService.getInstance();
        BranchService branchService = BranchService.getInstance();

        Vehicle suv111 = vehicleService.createCar("SUV111", 12.0, CarType.SUV);
        Vehicle sedan111 = vehicleService.createCar("SEDAN111", 10.0, CarType.SEDAN);
        Vehicle sedan112 = vehicleService.createCar("SEDAN112", 10.0, CarType.SEDAN);
        Vehicle sedan113 = vehicleService.createCar("SEDAN113", 10.0, CarType.SEDAN);
        Vehicle bike111 = vehicleService.createBike("BIKE111", 20.0);

        List<Vehicle> vehicles = Arrays.asList(suv111, sedan111, sedan112, sedan113, bike111);

        Branch gachibowliBranch = branchService.createBranch("gachibowli", bangalore.getId());

        return gachibowliBranch;
    }
}
