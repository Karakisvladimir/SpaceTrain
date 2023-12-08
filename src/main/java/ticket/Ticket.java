package ticket;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "ticket")
@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "passenger_id")
    private long passengerId;

    @Column(name = "from_planet")
    @Enumerated(EnumType.STRING)
    private Planet from;

    @Column(name = "to_planet")
    @Enumerated(EnumType.STRING)
    private Planet to;


    }

