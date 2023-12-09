package tests;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "person")

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
      //Use separate table
    @ElementCollection
    @CollectionTable(name = "person_address", joinColumns = @JoinColumn(name = "person_id"))
    @Column(name = "address")

      //Use the same table
//    @Column(name = "addresses")
//    @Convert(converter = AddressConverter.class)
    private List<String> addressList;
}
