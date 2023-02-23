package com.saksoft.employee.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
public class Employee {
	@Id
	@Min(1)
	private int eId;

	@NotEmpty
	@Size(min = 2, max = 25, message = "User First name must not empty & contain atleast 2 characters")
	private String eFirstName;

	@NotEmpty
	@Size(min = 2, max = 25, message = "User Last name must not empty & contain atleast 2 characters")
	private String eLastName;

	@Email(message = "Employee email should be mandatory ")
	private String eEmail;

	@Min(value = 18, message = "must be equal or greater than 18")
	private int eAge;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int eId, String eFirstName, String eLastName, String eEmail, int eAge) {
		super();
		this.eId = eId;
		this.eFirstName = eFirstName;
		this.eLastName = eLastName;
		this.eEmail = eEmail;
		this.eAge = eAge;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteFirstName() {
		return eFirstName;
	}

	public void seteFirstName(String eFirstName) {
		this.eFirstName = eFirstName;
	}

	public String geteLastName() {
		return eLastName;
	}

	public void seteLastName(String eLastName) {
		this.eLastName = eLastName;
	}

	public String geteEmail() {
		return eEmail;
	}

	public void seteEmail(String eEmail) {
		this.eEmail = eEmail;
	}

	public int geteAge() {
		return eAge;
	}

	public void seteAge(int eAge) {
		this.eAge = eAge;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eFirstName=" + eFirstName + ", eLastName=" + eLastName + ", eEmail=" + eEmail
				+ ", eAge=" + eAge + "]";
	}

}
