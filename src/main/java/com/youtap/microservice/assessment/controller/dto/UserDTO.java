package com.youtap.microservice.assessment.controller.dto;

import java.io.Serializable;

public class UserDTO  implements Serializable{

	private static final long serialVersionUID = 306860852418418854L;

	private Integer id;
    private String username;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


    @Override
    public int hashCode() {
        return id.hashCode()+username.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof UserDTO)) {
            return false;
        } else {
            UserDTO other = (UserDTO) obj;
            return this.id==other.id || this.username.equalsIgnoreCase(other.username);
        }
    }

    @Override
    public String toString() {
        return "UserDTO [id=" + id + ", username=" + username + "]";
    }

}
