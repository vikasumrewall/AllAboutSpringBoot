package com.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;

@Entity
@Table(name="district")
public class District implements java.io.Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id	
private @Expose Integer id;

private @Expose String name;

public District() {
	super();
	// TODO Auto-generated constructor stub
}
@ManyToOne
private @Expose State state;

public Integer getId() { 
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public State getState() {
	return state;
}
public void setState(State state) {
	this.state = state;
}
public District(Integer id, String name, State state) {
	super();
	this.id = id;
	this.name = name;
	this.state = state;
}

}
