package com.aws.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "First name should not be null or empty")
	@Size(min = 3, max = 70, message = "Fist name must be greater than 3 and less than 70 characters")
	@Column(name = "firstname", nullable = false, length = 70)
	private String firstName;

	@Column(name = "lastname", nullable = false, length = 70)
	@Size(min = 3, max = 70, message = "Last name must be greater than 3 and less than 70 characters")
	private String lastName;

	@NotEmpty(message = "E-mail should not be null or empty")
	@Email(message = "Email address should be valid", regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,10}")
	@Size(min = 5, max = 100, message = "E-mail must be greater than 5 and less than 100 characters")
	@Column(name = "email", nullable = false, length = 100, unique = true)
	private String email;

	@NotEmpty(message = "Password should not be null or empty")
	@Size(min = 8, max = 50, message = "Password must be greater than 8 and less than 50 characters")
	@Column(name = "password", nullable = false, length = 120)
	private String password;

	@JsonIgnore
	@Column(name = "active")
	private boolean active;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", active=");
		builder.append(active);
		builder.append("]");
		return builder.toString();
	}

	
	
}
