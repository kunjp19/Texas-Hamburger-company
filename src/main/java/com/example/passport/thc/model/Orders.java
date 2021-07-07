package com.example.passport.thc.model;

import lombok.*;

import javax.persistence.*;


@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "order_id")
    private long orderId;

    public Orders(String itemName, double price, String orderStatus, Locations locations) {
        this.itemName = itemName;
        this.price = price;
        this.orderStatus = orderStatus;
        this.locations = locations;
    }

    private String itemName;

    private double price;

    private String orderStatus;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "location_id")
    private Locations locations;

}
