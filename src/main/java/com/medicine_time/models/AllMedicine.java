package com.medicine_time.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
<<<<<<< HEAD
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
=======

>>>>>>> 1e74720fe18f6204ad44d36773f6858f18919761
@Entity(name="medicine")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AllMedicine {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	protected int id;

    @NotNull
    @Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

	public AllMedicine(){}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}