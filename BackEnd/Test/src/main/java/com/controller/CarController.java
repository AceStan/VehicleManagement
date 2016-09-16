package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.config.Response;
import com.model.Car;
import com.services.CarService;

@Controller
public class CarController {

	@Autowired
	private CarService carService;

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/addCar", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Response<Car> addCar(@RequestBody Car data) {
		Response<Car> r = new Response<>();
		r = carService.addCar(data);
		return r;

	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/deleteCar", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Response<Car> deleteCar(@RequestBody Car data) {
		Response<Car> r = new Response<>();
		r = carService.deleteCar(data);
		return r;

	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/updateCar", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Response<Car> updateCar(@RequestBody Car data) {
		Response<Car> r = new Response<>();
		r = carService.updateCar(data);
		return r;

	}

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/updateTrip", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Response<Car> updateTrip(@RequestBody Car data) {
		Response<Car> r = new Response<>();
		r = carService.updateTrip(data);
		return r;

	}
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/search", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ArrayList<Car> searchCars(@RequestBody String content) {
		System.out.println(content);
		ArrayList<Car> r = new ArrayList<>();
		r = carService.searchCars(content);
		return r;

	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/carDocumentation", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void carDoc(@RequestBody Car car) throws Exception {
		carService.carDocumentation(car);
		

	}
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping(value = "/carDocumentationHTML", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public void carDocHTML(@RequestBody Car car) throws Exception {
		carService.carDocumentationHTML(car);
		

	}
	


}
