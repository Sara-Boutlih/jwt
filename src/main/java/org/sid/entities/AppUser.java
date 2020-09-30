package org.sid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AppUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4961311576078158244L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true) /*la bd ne va pas accepter le meme username*/
	private String username;
	private String password;
	private String email;
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<AppRole> roles=new ArrayList<>();
	
	
//	public AppUser() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	public AppUser(Long id, String username, String password, Collection<AppRole> roles) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.roles = roles;
//	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<AppRole> getRoles() {
		return roles;
	}
	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}
	

}
