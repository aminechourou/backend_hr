package com.supportportal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "mission")
public class Mission {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
	Long id;
	String realisation;
	String autoEval;
	String feedBackManager;
	String etat ="on doing";
	@ManyToOne(optional = true)
    @JoinColumn(name = "projet",nullable = true,referencedColumnName = "id")
	Projet projet;
	@OneToOne
    @JoinColumn(name = "user_name",referencedColumnName = "username")
    private User user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRealisation() {
		return realisation;
	}
	public void setRealisation(String realisation) {
		this.realisation = realisation;
	}
	public String getAutoEval() {
		if(this.autoEval == null) {return "not submitted";}
		else return autoEval;
	}
	public void setAutoEval(String autoEval) {
		this.autoEval = autoEval;
	}
	public String getFeedBackManager() {
		if(this.feedBackManager == null) {return "not submitted";}
		else return feedBackManager;
	}
	public void setFeedBackManager(String feedBackManager) {
		this.feedBackManager = feedBackManager;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Mission(Long id, String realisation, String autoEval, String feedBackManager, Projet projet, User user) {
		super();
		this.id = id;
		this.realisation = realisation;
		this.autoEval = autoEval;
		this.feedBackManager = feedBackManager;
		this.projet = projet;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Mission [id=" + id + ", realisation=" + realisation + ", autoEval=" + autoEval + ", feedBackManager="
				+ feedBackManager + ", etat=" + etat + ", projet=" + projet.toString() + ", user=" + user.toString() + "]";
	}
	public Mission() {
		super();
	}
	
	
	
	
	
	
}
