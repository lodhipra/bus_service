package com.transport.bus_service.entity;

import javax.persistence.*;

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


}
