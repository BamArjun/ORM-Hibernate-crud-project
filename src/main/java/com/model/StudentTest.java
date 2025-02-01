package com.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class StudentTest {
public static void main(String[] args) {
	//add();
	//update();
	//delete();
	getAll();
	
}
static void add() {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	Student s = new Student();
	s.setName("Lokendra");
	s.setAge(23);
	s.setCollege("jhhjh");
	s.setCity("tokyo");
	session.save(s);//insert sql query
	session.getTransaction().commit();// sql execute
	session.close();
	
}
static void update() {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	Student s = (Student) session.get(Student.class, 4);
	s.setAge(20);
	s.setCollege("rich");
	
	session.update(s);// update table
	session.getTransaction().commit();
	session.close();
	
}
static void delete() {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
	session.beginTransaction();
	
	Student s = (Student) session.get(Student.class, 6);
	session.delete(s);
	session.getTransaction().commit();
	session.close();
}
static void getAll() {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
	Criteria crt= session.createCriteria(Student.class);
	crt.add(Restrictions.eq("collage", "prime"));// for case
	List<Student> slist = crt.list();
	System.out.println(slist);
}
}
