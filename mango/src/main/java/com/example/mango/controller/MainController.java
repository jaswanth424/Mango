package com.example.mango.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mango.service.CarService;
import com.example.mango.service.TruckService;

@RestController
@RequestMapping(path = "/demo")
public class MainController {

	@Autowired

	CarService carService;

//	@PostMapping(path = "/car/add")
//	@ResponseBody
//	public ResponseEntity<?> addCar(@RequestParam int year, @RequestParam String model, @RequestParam String type) {
//		return carService.addCar(year, model, type);
//	}
//
//	@GetMapping(path = "/car/getCars")
//	@ResponseBody
//	public ResponseEntity<?> getAllCars() {
//		return carService.getAllCars();
//	}
//
//	@GetMapping("/truck/get")
//	public ResponseEntity<?> getTrucks() {
//		return TruckService.getTrucks();
//	}
//
//	@GetMapping("/car/findById")
//	@ResponseBody
//	public ResponseEntity<?> findById(@RequestParam int id) {
//		return carService.getCarById(id);
//	}
////
////	@PostMapping(path = "/add")
////	public @ResponseBody String addMango(@RequestParam int id, @RequestParam String name) {
////		Mango m = new Mango();
////		m.setId(id);
////		m.setName(name);
////		mangoRepository.save(m);
////		return "Saved";
////	}

}
