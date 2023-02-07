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
@Table(name = "trajectoire")
public class Trajectoire {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
	Long id;
	String progression_visee;
	String progression_tech;
	String nextJob_visee;
	String nextJob_tech;
	String nextRank_visee;
	String nextRank_tech;
	String actions;
	@OneToOne
	@JoinColumn(name = "user_name",referencedColumnName = "username")
    private User user;
	public Trajectoire() {
		super();
	}
	public Trajectoire(Long id, String progression_visee, String progression_tech, String nextJob_visee,
			String nextJob_tech, String nextRank_visee, String nextRank_tech,String actions, User user) {
		super();
		this.id = id;
		this.progression_visee = progression_visee;
		this.progression_tech = progression_tech;
		this.nextJob_visee = nextJob_visee;
		this.nextJob_tech = nextJob_tech;
		this.nextRank_visee = nextRank_visee;
		this.nextRank_tech = nextRank_tech;
		this.actions =actions;
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProgression_visee() {
		return progression_visee;
	}
	public void setProgression_visee(String progression_visee) {
		this.progression_visee = progression_visee;
	}
	public String getProgression_tech() {
		return progression_tech;
	}
	public void setProgression_tech(String progression_tech) {
		this.progression_tech = progression_tech;
	}
	public String getNextJob_visee() {
		return nextJob_visee;
	}
	public void setNextJob_visee(String nextJob_visee) {
		this.nextJob_visee = nextJob_visee;
	}
	public String getNextJob_tech() {
		return nextJob_tech;
	}
	public void setNextJob_tech(String nextJob_tech) {
		this.nextJob_tech = nextJob_tech;
	}
	public String getNextRank_visee() {
		return nextRank_visee;
	}
	public void setNextRank_visee(String nextRank_visee) {
		this.nextRank_visee = nextRank_visee;
	}
	public String getNextRank_tech() {
		return nextRank_tech;
	}
	public void setNextRank_tech(String nextRank_tech) {
		this.nextRank_tech = nextRank_tech;
	}
	
	public String getActions() {
		return actions;
	}
	public void setActions(String actions) {
		this.actions = actions;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Trajectoire [id=" + id + ", progression_visee=" + progression_visee + ", progression_tech="
				+ progression_tech + ", nextJob_visee=" + nextJob_visee + ", nextJob_tech=" + nextJob_tech
				+ ", nextRank_visee=" + nextRank_visee + ", nextRank_tech=" + nextRank_tech + ", actions=" + actions
				+ ", user=" + user + "]";
	}
	
	
	
	
	
}
