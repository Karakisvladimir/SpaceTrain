package tests;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ElementCollection
    @CollectionTable(name = "person_address", joinColumns = @JoinColumn(name = "person_id"))
    @Column(name = "address")
    private List<String> addressList;
}
