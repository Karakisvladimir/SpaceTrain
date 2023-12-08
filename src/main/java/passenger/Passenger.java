package passenger;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "passenger")
@Entity
@Data
public class Passenger {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column
    private String passport;

    @Column
    private String name;
}
