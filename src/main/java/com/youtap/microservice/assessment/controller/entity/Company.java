package com.youtap.microservice.assessment.controller.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
public class Company  implements Serializable{
	private static final long serialVersionUID = 4469104255380099844L;
	private String name;
    private String catchPhrase;
    private String bs;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCatchPhrase() {
        return catchPhrase;
    }
    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }
    public String getBs() {
        return bs;
    }
    public void setBs(String bs) {
        this.bs = bs;
    }
}