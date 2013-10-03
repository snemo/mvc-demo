package com.wojciecholech.mvc.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;

/**
 * @author woj.olech@gmail.com
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "select p from Payment p"),
    @NamedQuery(name = "Payment.deleteAll", query = "delete from Payment")
})
public class Payment {

	private Long id;
	@NotNull
    @Size(min = 1, max = 50)
	private String firstName;
	@NotNull
    @Size(min = 1, max = 50)
	private String lastName;
	@NotNull
	@Email
	private String email;
	private BigDecimal amount;

	public Payment() {
	}
	
	public Payment(String firstName, String lastName, String email,	BigDecimal amount) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.amount = amount;
	}

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Long getId() {
		
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", amount=" + amount + "]";
	}
}
