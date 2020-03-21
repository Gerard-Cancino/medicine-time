package com.revature.medicine_time.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

@Entity(name="user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	protected long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private int lastName;
	@Column(name="date_of_birth")
	private int dateOfBirth;
	@Column(name="phone_number")
	private int phoneNumber;
	@Column(name="email")
	private String email;
	@NotNull
	@Column(name="username")
	private String username;
	@NotNull
	@Column(name="password")
	private String password;
	@NotNull
	@Column(name="role_type")
	private String roleType;
}
