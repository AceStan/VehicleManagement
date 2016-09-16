package com.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.config.HibernateUtil;
import com.config.Response;
import com.dao.CarDao;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.model.Car;

@Repository
public class CarDaoImpl implements CarDao {
	SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public Response<Car> addCar(Car car) {
		Response<Car> r =  new Response<>();
		r.setData(car);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try{
		
		session.save(car);
		tx.commit();
		r.setOkSSID(true);
		}
		catch(Exception e){
			r.setOkSSID(false);
			e.printStackTrace();
			tx.rollback();
		}
		return r;
	}

	@Override
	public Response<Car> deleteCar(Car car) {
		Response<Car> r =  new Response<>();
		r.setData(car);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try{
		
		session.delete(car);
		tx.commit();
		r.setOkSSID(true);
		}
		catch(Exception e){
			r.setOkSSID(false);
			e.printStackTrace();
			tx.rollback();
		}
		return r;
	}

	@Override
	public Response<Car> updateCar(Car car) {

		Response<Car> r =  new Response<>();
		r.setData(car);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try{
		
		session.update(car);
		tx.commit();
		r.setOkSSID(true);
		}
		catch(Exception e){
			r.setOkSSID(false);
			e.printStackTrace();
			tx.rollback();
		}
		return r;
	}

	@Override
	public Response<Car> updateTrip(Car car) {
		Car tmp;
		Float kmNew ;
		Response<Car> r =  new Response<>();
		r.setData(car);
		Session session = sf.openSession();
		System.out.println(car.getKm());
		try{
		tmp  = (Car)session.get(Car.class, car.getId());
		kmNew = tmp.getKm() + car.getKm();
		System.out.println(kmNew);
		car.setKm(kmNew);
		session.close();
		session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(car);
		tx.commit();
		r.setOkSSID(true);
		}
		catch(Exception e){
			r.setOkSSID(false);
			e.printStackTrace();
			
		}
		session.close();
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Car> searchCars(String content) {
		
		ArrayList<Car> res =  new ArrayList<>();
		Session session = sf.openSession();
		String[] contentParts =  content.split(" ");
		
		for(String a:contentParts)
		{
			System.out.println(a);
		}
		try{
			Criteria c =  session.createCriteria(Car.class);
			Criteria c1 = session.createCriteria(Car.class);
			
			for(String a:contentParts)
			{	
				
				c.add(Restrictions.eq("brand",a));
				res.addAll((ArrayList<Car>) c.list());
				c1.add(Restrictions.eq("model",a));
				res.addAll((ArrayList<Car>) c1.list());
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		System.out.println("THIS IS THE SEARCH RESULT :");
		System.out.println(res);
		return res;
	}

	@Override
	public void carDocumentation(Car car) throws Exception {
		
		Session s = sf.openSession();
		Car res = new Car();
		Document pdf = new Document();
		PdfWriter.getInstance(pdf, new FileOutputStream("/Users/aleksandar.stanoevsk/Desktop/VehicleManagement v.1.1/files/carDocumentation.pdf"));
		try {
			pdf.open();
			Criteria c = s.createCriteria(Car.class);
			c.add(Restrictions.eq("id",car.getId()));
			res = (Car)c.uniqueResult();
			Font f = FontFactory.getFont("Arial",8);
			Font tile = FontFactory.getFont("Tahoma",12);
			Paragraph title =  new Paragraph("Vehicle Management - Car documentatiton \n \n \n");
			title.setAlignment(5);
			pdf.add(title);
			Paragraph p = new Paragraph("Car Brand : "+car.getBrand() +"\n"+
			"Car Model : "+car.getModel()+"\n"+
			 "Engine power : "+car.getEngine()+" horse powers"+"\n"+
			 "Average fuel consumption : " + car.getFuelCompsumption()+" liters / 100 kms"+"\n"+
			 "Last Service : "+ car.getLastService()+"\n",f);
			pdf.add(p);
			pdf.close();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void carDocumentationHTML(Car car) throws Exception {
		Session s = sf.openSession();
		Car res = new Car();
		File f = new File ("/Users/aleksandar.stanoevsk/Desktop/VehicleManagement v.1.1/files/carDocHTML.html");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			String html = "<header>Vehicle Management - Car Documenatatiton:</header>"
					+ "<br><br>"
					+ "<p>Car Brand : "+car.getBrand()+"</p>"
					+ "<p>Car Model : "+car.getModel()+"</p>"
					+ "<p>Engine Power : "+car.getEngine()+" horse powers</p>"
					+ "<p>Average Fuel Consumption : "+car.getFuelCompsumption()+" liters/100kms</p>"
					+ "<p>LastService : "+car.getLastService()+"</p>";
			bw.write(html);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
