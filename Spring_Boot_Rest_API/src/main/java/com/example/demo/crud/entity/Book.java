package com.example.demo.crud.entity;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	
@Id @GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String name;
private String qualification;
private String city;
public int getId() {
	return id;
}
public Book(int id, String name, String qualification, String city) {
	super();
	this.id = id;
	this.name = name;
	this.qualification = qualification;
	this.city = city;
}
public Book() {
	super();
	// TODO Auto-generated constructor stub
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
}
