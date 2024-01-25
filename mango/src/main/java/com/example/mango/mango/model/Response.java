package com.example.mango.mango.model;

import java.util.List;

import com.example.mango.car.model.Car;

import lombok.Data;

@Data
public class Response {
    List<Car> cars;
    List<Mango> mangos;
}
