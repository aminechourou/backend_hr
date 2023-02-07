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
@Table(name = "eval_comite")
public class EvalComite {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
	Long id;
	String mission;
	String attenduVSrank;
	String contributions;
	String appreciation;
	String synthese_globale;
	@OneToOne
	@JoinColumn(name = "user_name",referencedColumnName = "username")
    private User user;
	
	
	public EvalComite() {
		super();
	}
	
	
	public EvalComite(Long id, String mission, String attenduVSrank, String contributions, String appreciation,
			String synthese_globale, User user) {
		super();
		this.id = id;
		this.mission = mission;
		this.attenduVSrank = attenduVSrank;
		this.contributions = contributions;
		this.appreciation = appreciation;
		this.synthese_globale = synthese_globale;
		this.user = user;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMission() {
		return mission;
	}
	public void setMission(String mission) {
		this.mission = mission;
	}
	public String getAttenduVSrank() {
		return attenduVSrank;
	}
	public void setAttenduVSrank(String attenduVSrank) {
		this.attenduVSrank = attenduVSrank;
	}
	public String getContributions() {
		return contributions;
	}
	public void setContributions(String contributions) {
		this.contributions = contributions;
	}
	public String getAppreciation() {
		return appreciation;
	}
	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}
	public String getSynthese_globale() {
		return synthese_globale;
	}
	public void setSynthese_globale(String synthese_globale) {
		this.synthese_globale = synthese_globale;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "EvalComite [id=" + id + ", mission=" + mission + ", attenduVSrank=" + attenduVSrank + ", contributions="
				+ contributions + ", appreciation=" + appreciation + ", synthese_globale=" + synthese_globale
				+ ", user=" + user + "]";
	}
	
}
