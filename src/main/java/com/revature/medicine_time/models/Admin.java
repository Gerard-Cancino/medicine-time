package com.revature.medicine_time.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="Admin")
@Table(name="admin")
public class Admin extends User{}
