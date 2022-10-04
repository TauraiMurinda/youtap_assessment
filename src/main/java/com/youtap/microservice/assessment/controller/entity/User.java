package com.youtap.microservice.assessment.controller.entity;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User implements Serializable{
	
	   private static final Logger LOG = LoggerFactory.getLogger(User.class);

    private static final long serialVersionUID = -5137552934413132517L;
	private Integer id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;



    @Override
    public int hashCode() {
        return "12345".hashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof User)) {
    	   LOG.info(" !(obj instanceof User");
            return false;
        } else {
            User other = (User) obj;
            if(this.id!=null || other.getId()!=null) {
              LOG.info("this.id==other.id  "  + this.getId()+ "  "+other.getId() + "  " + (this.getId()==other.getId()));
            	return this.getId()==other.getId();
            }
            
            if(this.username!=null || other.getUsername()!=null) {
            	LOG.info("this.username.equalsIgnoreCase(other.username)");
            	return this.getUsername().equalsIgnoreCase(other.getUsername());

            }
            
            return false;
        }
    }
    
    
    @Override
    public String toString() {
        return "\n User [id=" + id + ",\n username=" + username + ",\n email=" + getEmail() + ",\n phone=" + getPhone() + "]";
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }



}