package com.test.flipcar.repositories;

import com.test.flipcar.beans.Branch;
import com.test.flipcar.beans.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BranchRepository {
    private static BranchRepository instance;
    private Map<String, List<Branch>> cityBranchesMap;
    private Map<String, Branch> branchMap;
    private Map<String, List<Vehicle>> branchVehiclesMap;

    private BranchRepository() {
        this.branchVehiclesMap = new HashMap<>();
        this.cityBranchesMap = new HashMap<>();
        this.branchMap = new HashMap<>();
    }

    public static BranchRepository getInstance() {
        if (instance == null) {
            instance = new BranchRepository();
        }
        return instance;
    }

    public Branch save(Branch branch) {
        branchMap.putIfAbsent(branch.getId(), branch);
        cityBranchesMap.putIfAbsent(branch.getCityId(), new ArrayList<>());
        cityBranchesMap.get(branch.getCityId()).add(branch);
        return branch;
    }

    public void addVehicle(String branchId, Vehicle vehicle) {
        branchVehiclesMap.putIfAbsent(branchId, new ArrayList<>());
        branchVehiclesMap.get(branchId).add(vehicle);
    }

    public List<Vehicle> findBranchVehicles(String branchId) {
        return branchVehiclesMap.getOrDefault(branchId, new ArrayList<>());
    }

    public List<Branch> findBranches(String cityId) {
        return cityBranchesMap.getOrDefault(cityId, new ArrayList<>());
    }
}
