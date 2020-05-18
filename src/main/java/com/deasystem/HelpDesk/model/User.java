package com.deasystem.HelpDesk.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	@Email(message="Por favor, informe um E-mail válido.")
	@NotEmpty(message = "E-mail não pode estar vazio.")
	private String email;
	
	@Column
	@NotEmpty(message = "Nome não pode estar vazio.")
	private String name;
	
	@Column
	@NotEmpty(message = "Senha não pode estar vazio.")
	@Length(min=7, message = "Campo senha deve conter no mínimo 5 caracteres.")
	private String password;
	
	@Column
	private Boolean active;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="user_roles",
		joinColumns = @JoinColumn(name="user_id"), 
		inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles;
	
	public User() {
	
	}
		
	public User(String email, String name, String password, Boolean active) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.active = active;
	}

	public User(Long id, String email, String name, String password, Boolean active) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.active = active;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
