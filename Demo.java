package com.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Demo {

	public static void main(String[] args) {
		
		Configuration c = new Configuration();
		c.configure("hibernate.cfg.xml");
		
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		
		Transaction t = s.beginTransaction();
		
		Vehicle v=new Vehicle();
		v.setId(101l);
		
		Car c1=new Car();
		c1.setCarName("maruti");
		
		Bike b=new Bike();
		b.setBikeName("pulsar");
		
		s.save(v);
		s.save(c1);
		s.save(b);
		
	
		String hql = "FROM Vehicle";
		Query query = s.createQuery(hql);
		List<Vehicle> vehicles = query.list();

		for(Vehicle vehicle:vehicles)
		{
			System.out.println("Vehicle ID : "+vehicle.getId());
		}
		
		t.commit();
		s.close();

	}

}
