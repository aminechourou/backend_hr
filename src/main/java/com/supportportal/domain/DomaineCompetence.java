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
@Table(name = "domainecompetence")
public class DomaineCompetence {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
	Long id;
	String titre;
	String sousTitre;
	String posture;
	String autoEval;
	String managerEval;
	@ManyToOne(optional = true)
    @JoinColumn(name = "user",nullable = true,referencedColumnName = "username")
    private User user;
	public DomaineCompetence() {
		super();
	}
	public DomaineCompetence(Long id, String titre, String sousTitre, String posture, String autoEval,
			String managerEval, User user) {
		super();
		this.id = id;
		this.titre = titre;
		this.sousTitre = sousTitre;
		this.posture = posture;
		this.autoEval = autoEval;
		this.managerEval = managerEval;
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getSousTitre() {
		return sousTitre;
	}
	public void setSousTitre(String sousTitre) {
		this.sousTitre = sousTitre;
	}
	public String getPosture() {
		return posture;
	}
	public void setPosture(String posture) {
		this.posture = posture;
	}
	public String getAutoEval() {
		return autoEval;
	}
	public void setAutoEval(String autoEval) {
		this.autoEval = autoEval;
	}
	public String getManagerEval() {
		return managerEval;
	}
	public void setManagerEval(String managerEval) {
		this.managerEval = managerEval;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "DomaineCompetence [id=" + id + ", titre=" + titre + ", sousTitre=" + sousTitre + ", posture=" + posture
				+ ", autoEval=" + autoEval + ", managerEval=" + managerEval + ", user=" + user.toString() + "]";
	}
	public DomaineCompetence(String titre, String sousTitre, String posture, String autoEval, String managerEval,
			User user) {
		
		this.titre = titre;
		this.sousTitre = sousTitre;
		this.posture = posture;
		this.autoEval = autoEval;
		this.managerEval = managerEval;
		this.user = user;
	}
	
	
	

}
