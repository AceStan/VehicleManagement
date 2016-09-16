package com.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.config.Response;
import com.dao.CarDao;
import com.model.Car;

@Service
public class CarService {
	
	@Autowired
	private CarDao carDao;
	
	public Response<Car> addCar(Car car)
	{
		return carDao.addCar(car);
	}
	public Response<Car> deleteCar(Car car){
		return carDao.deleteCar(car);
	}
	public Response<Car> updateTrip(Car car)
	{
		return carDao.updateCar(car);
	}
	public Response<Car> updateCar(Car car)
	{
		return carDao.updateCar(car);
	}
	public ArrayList<Car> searchCars(String content)
	{
		Set<Car> set = new HashSet<>();
		ArrayList<Car> result = carDao.searchCars(content);
		set.addAll(result);
		result.clear();
		result.addAll(set);
		return result;
		
	}
	public void carDocumentation(Car car) throws Exception{
		carDao.carDocumentation(car);
	}
	public void carDocumentationHTML(Car car) throws Exception{
		carDao.carDocumentationHTML(car);
	}
	

}
