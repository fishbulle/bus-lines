package com.example.buslines.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "bus")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private Long id;

    @Column(name = "line_number")
    private String lineNumber;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StopEntity> stops;
}
