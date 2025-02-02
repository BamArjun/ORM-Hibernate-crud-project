package com.model;

import java.util.Arrays;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MappingTest {
public static void main(String[] args) {
//	OneToOne();
	oneToMany();
}
static void OneToOne() {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	Address ad= new Address();
	ad.setCountry("nepal");
	ad.setCity("ktm");
	ad.setState("stste-3");
	
	session.save(ad);
	Employee e= new Employee();
	e.setName("ram");
	e.setAddress(ad);
	e.setSalary(10000);
	session.save(e);
	session.getTransaction().commit();
	session.close();
}
static void oneToMany() {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	Address ad= new Address();
	ad.setCountry("nepal");
	ad.setCity("ktm");
	ad.setState("stste-3");
	
	session.save(ad);
	Employee e= new Employee();
	e.setName("ram");
	e.setAddress(ad);
	e.setSalary(10000);
	
	session.save(e);

	Phone p = new Phone();
	p.setEmployee(e);
	p.setNumber("9839273");
	p.setType("ntc");
	session.save(p);

	Phone p1 = new Phone();
	p1.setEmployee(e);
	p1.setNumber("98392000073");
	p1.setType("ncell");
	e.setPhone(Arrays.asList(p,p1));
	
	session.save(p1);
	session.getTransaction().commit();
	session.close();
}
}
