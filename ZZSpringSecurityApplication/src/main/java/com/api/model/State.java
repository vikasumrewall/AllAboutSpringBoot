package com.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;

@Entity
@Table(name="state")
public class State  implements java.io.Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public State() {
	super();
}
@Id	
private @Expose Integer id;

private @Expose String name;


@OneToMany(mappedBy = "state")
private  List<District> district;

public State(Integer id, String name,List<District> district) {
	super();
	this.id = id;
	this.name = name;
	this.district = district;
}
public List<District> getDistrict() {
	return district;
}
public void setDistrict(List<District> district) {
	this.district = district;
}
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

}
