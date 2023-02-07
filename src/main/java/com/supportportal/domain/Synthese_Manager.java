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
@Table(name = "synthese_manager")
public class Synthese_Manager {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
	Long id;
	String performance;
	String notePerformance;
	String contribution;
	String noteContribution;
	String rank;
	String noteRank;
	@OneToOne
    @JoinColumn(name = "user_name",referencedColumnName = "username")
    private User user;
	
	public Synthese_Manager() {
		super();
	}

	public Synthese_Manager(Long id, String performance, String notePerformance, String contribution,
			String noteContribution, String rank, String noteRank, User user) {
		super();
		this.id = id;
		this.performance = performance;
		this.notePerformance = notePerformance;
		this.contribution = contribution;
		this.noteContribution = noteContribution;
		this.rank = rank;
		this.noteRank = noteRank;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}

	public String getNotePerformance() {
		return notePerformance;
	}

	public void setNotePerformance(String notePerformance) {
		this.notePerformance = notePerformance;
	}

	public String getContribution() {
		return contribution;
	}

	public void setContribution(String contribution) {
		this.contribution = contribution;
	}

	public String getNoteContribution() {
		return noteContribution;
	}

	public void setNoteContribution(String noteContribution) {
		this.noteContribution = noteContribution;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getNoteRank() {
		return noteRank;
	}

	public void setNoteRank(String noteRank) {
		this.noteRank = noteRank;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Synthese_Manager [id=" + id + ", performance=" + performance + ", notePerformance=" + notePerformance
				+ ", contribution=" + contribution + ", noteContribution=" + noteContribution + ", rank=" + rank
				+ ", noteRank=" + noteRank + ", user=" + user + "]";
	}
	
	
	
}
