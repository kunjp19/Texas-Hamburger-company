package com.example.passport.thc.model;

import lombok.*;
import javax.persistence.*;


@Data
@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "locations")
public class Locations {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "location_id")
    private Long locationId;

    private String name;

    private String address_line1;

    private String address_line2;

    private String city;

    private String state;

    private int zipCode;

    private String locationStatus;

//    @OneToOne(mappedBy = "locations", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//    private Menus menus;
//
//    @OneToMany(mappedBy = "locations", targetEntity = Reservations.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Set<Reservations> reservations = new HashSet<>();

//    @OneToMany(mappedBy = "locations", targetEntity = OpenHours.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Set<OpenHours> openHours = new HashSet<>();
////
//    @ManyToMany(mappedBy = "locations", targetEntity = Orders.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Set<Orders> orders = new HashSet<>();


    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress_line1(String address_line1) {
        this.address_line1 = address_line1;
    }

    public void setAddress_line2(String address_line2) {
        this.address_line2 = address_line2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setLocationStatus(String locationStatus) {
        this.locationStatus = locationStatus;
    }
}
