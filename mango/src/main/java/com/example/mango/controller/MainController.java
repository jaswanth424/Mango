package com.example.mango.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mango.h2.repository.H2Repository;
import com.example.mango.mango.model.Response;
import com.example.mango.mysql.repository.MysqlRepository;

@RestController
@RequestMapping(path = "/demo")
public class MainController {

	@Autowired
	MysqlRepository mysqlRepository;

	@Autowired
	H2Repository h2Repository;
	
	@GetMapping("/")
	public Response getResponse() {
        Response response = new Response();
        response.setCars(mysqlRepository.findAll());
        response.setMangos(h2Repository.findAll());
        return response;
	}
}
