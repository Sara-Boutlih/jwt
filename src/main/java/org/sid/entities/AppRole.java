package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AppRole implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2506323017863484395L;
	
	@Id
	private Long id;
	private String roleName;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	

}
