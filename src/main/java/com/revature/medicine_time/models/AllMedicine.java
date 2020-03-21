package main.java.com.revature.medicine_time.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

@Entity(name="allMedicine")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AllMedicine {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="medicine_id")
    protected long id;
    @NotNull
    @Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
}