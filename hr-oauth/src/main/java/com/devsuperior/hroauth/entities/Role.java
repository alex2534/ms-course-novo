package com.devsuperior.hroauth.entities;

import java.io.Serializable;
import java.util.Objects;



public class Role implements Serializable{
	private static final long serialVersionUID = 1L;
	

	private Long id;
	private String RoleName;
	
	public Role() {
		
	}

	public Role(Long id, String roleName) {
		super();
		this.id = id;
		RoleName = roleName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", RoleName=" + RoleName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(RoleName, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(RoleName, other.RoleName) && Objects.equals(id, other.id);
	}
	
	

}
