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
@Table(name = "synthese_auto_eval")
public class SyntheseAutoEval {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
	Long id;
	String ptsForts;
	String ptsFortsManger;
	String enseignements;
	String enseignementsManager;
	String axesAmeliorations;
	String axesAmeliorationsManager;
	String satisfaction;
	String attentes;
	@OneToOne
    @JoinColumn(name = "user_name",referencedColumnName = "username")
    private User user;
	public SyntheseAutoEval() {
		super();
	}
	
	public SyntheseAutoEval(Long id, String ptsForts, String ptsFortsManger, String enseignements,
			String enseignementsManager, String axesAmeliorations, String axesAmeliorationsManager, String satisfaction,
			String attentes, User user) {
		super();
		this.id = id;
		this.ptsForts = ptsForts;
		this.ptsFortsManger = ptsFortsManger;
		this.enseignements = enseignements;
		this.enseignementsManager = enseignementsManager;
		this.axesAmeliorations = axesAmeliorations;
		this.axesAmeliorationsManager = axesAmeliorationsManager;
		this.satisfaction = satisfaction;
		this.attentes = attentes;
		this.user = user;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPtsForts() {
		return ptsForts;
	}
	public void setPtsForts(String ptsForts) {
		this.ptsForts = ptsForts;
	}
	public String getPtsFortsManger() {
		return ptsFortsManger;
	}
	public void setPtsFortsManger(String ptsFortsManger) {
		this.ptsFortsManger = ptsFortsManger;
	}
	public String getEnseignements() {
		return enseignements;
	}
	public void setEnseignements(String enseignements) {
		this.enseignements = enseignements;
	}
	public String getEnseignementsManager() {
		return enseignementsManager;
	}
	public void setEnseignementsManager(String enseignementsManager) {
		this.enseignementsManager = enseignementsManager;
	}
	public String getAxesAmeliorations() {
		return axesAmeliorations;
	}
	public void setAxesAmeliorations(String axesAmeliorations) {
		this.axesAmeliorations = axesAmeliorations;
	}
	public String getAxesAmeliorationsManager() {
		return axesAmeliorationsManager;
	}
	public void setAxesAmeliorationsManager(String axesAmeliorationsManager) {
		this.axesAmeliorationsManager = axesAmeliorationsManager;
	}
	public String getSatisfaction() {
		return satisfaction;
	}
	public void setSatisfaction(String satisfaction) {
		this.satisfaction = satisfaction;
	}
	public String getAttentes() {
		return attentes;
	}
	public void setAttentes(String attentes) {
		this.attentes = attentes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SyntheseAutoEval [id=" + id + ", ptsForts=" + ptsForts + ", ptsFortsManger=" + ptsFortsManger
				+ ", enseignements=" + enseignements + ", enseignementsManager=" + enseignementsManager
				+ ", axesAmeliorations=" + axesAmeliorations + ", axesAmeliorationsManager=" + axesAmeliorationsManager
				+ ", satisfaction=" + satisfaction + ", attentes=" + attentes + ", user=" + user + "]";
	}
	
	
	
}
