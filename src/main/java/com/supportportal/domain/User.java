package com.supportportal.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String email;
    private String profileImageUrl;
    private Date lastLoginDate;
    private Date lastLoginDateDisplay;
    private Date joinDate;
    private String role; 
    private String rank;
    private String job;
    private String offre;
    private String prefOffre;
    private String experience;
    private String[] authorities;
    private boolean isActive;
    private boolean isNotLocked;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "manager",nullable = true,referencedColumnName = "id")
    private User manager;
    
    
 
    
  
    
    

    public User(){}
    
    
     


	public User(String username) {
		
		this.username = username;
	}





	public User(Long id, String userId, String firstName, String lastName, String username, String password,
			String email, String profileImageUrl, Date lastLoginDate, Date lastLoginDateDisplay, Date joinDate,
			String role, String rank, String job, String offre, String prefOffre, String experience,
			String[] authorities, boolean isActive, boolean isNotLocked, User manager) {
		
		this.id = id;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.profileImageUrl = profileImageUrl;
		this.lastLoginDate = lastLoginDate;
		this.lastLoginDateDisplay = lastLoginDateDisplay;
		this.joinDate = joinDate;
		this.role = role;
		this.rank = rank;
		this.job = job;
		this.offre = offre;
		this.prefOffre = prefOffre;
		this.experience = experience;
		this.authorities = authorities;
		this.isActive = isActive;
		this.isNotLocked = isNotLocked;
		this.manager = manager;
	}
       



	public User(String userId, String firstName, String lastName, String username, String password, String email,
			String profileImageUrl, Date lastLoginDate, Date lastLoginDateDisplay, Date joinDate, String role,
			String rank, String job, String offre, String prefOffre, String experience, String[] authorities,
			boolean isActive, boolean isNotLocked, User manager) {
		
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.profileImageUrl = profileImageUrl;
		this.lastLoginDate = lastLoginDate;
		this.lastLoginDateDisplay = lastLoginDateDisplay;
		this.joinDate = joinDate;
		this.role = role;
		this.rank = rank;
		this.job = job;
		this.offre = offre;
		this.prefOffre = prefOffre;
		this.experience = experience;
		this.authorities = authorities;
		this.isActive = isActive;
		this.isNotLocked = isNotLocked;
		this.manager = manager;
	}
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public Date getLastLoginDate() {
    	
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getLastLoginDateDisplay() {
        return lastLoginDateDisplay;
    }

    public void setLastLoginDateDisplay(Date lastLoginDateDisplay) {
        this.lastLoginDateDisplay = lastLoginDateDisplay;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String[] getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String[] authorities) {
        this.authorities = authorities;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isNotLocked() {
        return isNotLocked;
    }

    public void setNotLocked(boolean notLocked) {
        isNotLocked = notLocked;
    }



	public String getRank() {
		return rank;
	}



	public void setRank(String rank) {
		this.rank = rank;
	}



	public String getJob() {
		return job;
	}



	public void setJob(String job) {
		this.job = job;
	}



	public String getOffre() {
		return offre;
	}



	public void setOffre(String offre) {
		this.offre = offre;
	}



	public String getPrefOffre() {
		return prefOffre;
	}



	public void setPrefOffre(String prefOffre) {
		this.prefOffre = prefOffre;
	}



	public String getExperience() {
		return experience;
	}



	public void setExperience(String experience) {
		this.experience = experience;
	}


   
	public String getManager() {
		if(this.manager == null) {
			return "no manager";
		}
		else return manager.username;
	}



	public void setManager(User manager) {
		this.manager = manager;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", password=" + password + ", email=" + email + ", profileImageUrl="
				+ profileImageUrl + ", lastLoginDate=" + lastLoginDate + ", lastLoginDateDisplay="
				+ lastLoginDateDisplay + ", joinDate=" + joinDate + ", role=" + role + ", rank=" + rank + ", job=" + job
				+ ", offre=" + offre + ", prefOffre=" + prefOffre + ", experience=" + experience + ", authorities="
				+ Arrays.toString(authorities) + ", isActive=" + isActive + ", isNotLocked=" + isNotLocked
				+ ", manager=" +manager.getUsername().toString() + " ]";
	}
	
	
    
}
