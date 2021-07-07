package com.example.passport.thc.model;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "menus")
public class Menus {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "menu_id")
    private long menuId;

    private String itemName;

    private String itemType;

    private double price;

    private String itemStatus;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "location_id")
    private Locations locations;
}
