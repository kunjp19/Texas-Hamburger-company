package com.example.passport.thc.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservations")
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "reservation_id")
    private long reservationId;

    private String customerName;

    private long phoneNumber;

    private Time createdAt;

    private String date;

    private String startTime;

    private String endTime;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "location_id")
    private Locations locations;
}


