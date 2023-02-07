package com.supportportal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "objective")
public class Objectives {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
	Long id;
	String description;
	String etat;
	@OneToOne
    @JoinColumn(name = "user_name",referencedColumnName = "username")
    private User user;
	
	
	public Objectives() {
		super();
	}


	public Objectives(Long id, String description, String etat, User user) {
		super();
		this.id = id;
		this.description = description;
		this.etat = etat;
		this.user = user;
	}


	@Override
	public String toString() {
		return "Objectives [id=" + id + ", description=" + description + ", etat=" + etat + ", user=" + user + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
