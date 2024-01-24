package com.example.mango.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mango.model.Truck;
import com.example.mango.repository.TruckRepository;

@Service
public class TruckService {

    @Autowired
    private TruckRepository truckRepository;

    public List<Truck> getAllTrucks() {
        return truckRepository.findAll();
    }

    public Truck saveTruck(Truck truck) {
        return truckRepository.save(truck);
    }
}
