package com.transport.bus_service.entity;

import javax.persistence.*;

@Entity
@Table(name = "busStop")
public class BusStop {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 16, nullable = false)
    private String name;

    @Column(name = "address", length = 256, nullable = false)
    private String address;


}
