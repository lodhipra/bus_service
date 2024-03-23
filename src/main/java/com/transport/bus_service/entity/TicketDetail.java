package com.transport.bus_service.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticketDetail")
@Getter
@Setter
@NoArgsConstructor
public class TicketDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private RegistrationDetail user;

    @Column(name = "createdDate", length = 16, nullable = false)
    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name="bus_id", nullable=false)
    private BusDetail bus;

    @ManyToOne
    @JoinColumn(name="pickUp", nullable=false)
    private BusStop pickUp;

    @Column(name = "seatNo", length = 16, nullable = false)
    private int seatNo;

}
