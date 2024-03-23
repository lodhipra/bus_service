package com.transport.bus_service.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "busDetail")
public class BusDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "busNumber", length = 16, nullable = false)
    private String busNumber;

    @ManyToOne
    @JoinColumn(name="source_id", nullable=false)
    private BusStop source;

    @ManyToOne
    @JoinColumn(name="destination_id", nullable=false)
    private BusStop destination;

    @Column(name = "journey", nullable = false)
    private LocalDateTime journey;

    @Column(name = "passengers", nullable = false)
    private LocalDateTime passengers;

    @ManyToMany
    @JoinColumn(name="stops", nullable=false)
    private List<BusStop> stops;
}
