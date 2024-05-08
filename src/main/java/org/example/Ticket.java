package org.example;


import javax.persistence.*;
import java.util.Objects;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "start_planet_id", nullable = false)
    private Planet startPlanet;

    @ManyToOne
    @JoinColumn(name = "destination_planet_id", nullable = false)
    private Planet distinationPlanet;

}
