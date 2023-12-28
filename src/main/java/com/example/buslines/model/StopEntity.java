package com.example.buslines.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "stop")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stop_id")
    private Long id;

    @Column(name = "stop_number")
    private String stopPointNumber;

    @Column(name = "stop_name")
    private String stopPointName;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private BusEntity bus;
}
