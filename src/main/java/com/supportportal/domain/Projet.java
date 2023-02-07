package com.supportportal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "projet")
public class Projet {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
	Long id;
	String titre;
	String description;
	String dure;
	String etat;
	String client;
	@ManyToOne(optional = true)
    @JoinColumn(name = "chef",nullable = true,referencedColumnName = "id")
    private User chef;
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
	public String getDure() {
		return dure;
	}
	public void setDure(String dure) {
		this.dure = dure;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public User getChef() {
		return chef;
	}
	public void setChef(User chef) {
		this.chef = chef;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Projet(Long id, String titre, String description, String dure, String etat, String client, User chef) {
		
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.dure = dure;
		this.etat = etat;
		this.client = client;
		this.chef = chef;
	}
	
	public Projet(String titre, String description, String dure, String etat, String client, User chef) {
		super();
		this.titre = titre;
		this.description = description;
		this.dure = dure;
		this.etat = etat;
		this.client = client;
		this.chef = chef;
	}
	public Projet() {
	}
	@Override
	public String toString() {
		return "Projet [id=" + id + ", titre=" + titre + ", description=" + description + ", dure=" + dure + ", etat="
				+ etat + ", client=" + client + ", chef=" + chef + "]";
	}
	
	
	
	
}
