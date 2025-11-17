package com.snevoride.snevoride.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;

    private Boolean available = true;

    private Double latitude;
    private Double longitude;

    private String vehicleNumber;
    private String vehicleType;

    public Driver() {} // default constructor

    public Driver(String name, String phone, Boolean available,
                  Double latitude, Double longitude,
                  String vehicleNumber, String vehicleType) {
        this.name = name;
        this.phone = phone;
        this.available = available;
        this.latitude = latitude;
        this.longitude = longitude;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public Driver(long l, String johnDoe, String number, boolean b, double v, double v1, String ka01AB1234, String sedan) {
    }


    public void setLatitude(Object latitude) {
    }

    public void setLongitude(Object longitude) {
    }

    public void setId(Long id) {
    }
}
