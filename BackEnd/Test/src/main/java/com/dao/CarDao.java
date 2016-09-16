package com.dao;

import java.util.ArrayList;

import com.config.Response;
import com.model.Car;

public interface CarDao {
	public Response<Car> addCar(Car car);
	public Response<Car> deleteCar(Car car);
	public Response<Car> updateCar(Car car);
	public Response<Car> updateTrip(Car car);
	public ArrayList<Car> searchCars(String content);
	public void carDocumentation(Car car) throws Exception;
	
}