package com.youtap.microservice.assessment.controller.entity;

import java.io.Serializable;

public class Geo  implements Serializable{
	private static final long serialVersionUID = 1534037466943404894L;
	private String lat;
    private String lng;
    public String getLat() {
        return lat;
    }
    public void setLat(String lat) {
        this.lat = lat;
    }
    public String getLng() {
        return lng;
    }
    public void setLng(String lng) {
        this.lng = lng;
    }
}