package org.example;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Ticket {
    private Long id;
    private LocalDateTime createdAt;
    private Client client;
    private Planet fromPlanet;
    private Planet toPlanet;
}
