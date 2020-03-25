package jon.playground.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee {
	
	@Id
	@Column
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String gender;
	
	@Column
	private String department;
	
	@Column
	private Date dob;
	
	
}
