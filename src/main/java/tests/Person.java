package tests;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "person")

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
      //Use separate table
//    @ElementCollection
//    @CollectionTable(name = "person_address", joinColumns = @JoinColumn(name = "person_id"))
//    @Column(name = "address")

      //Use the same table
    @Column(name = "addresses")
    @Convert(converter = AddressConverter.class)
    private List<String> addressList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "person_id")
    private PersonInfo personInfo;

    @OneToMany(mappedBy = "person")
    private List<Workplace> workplaces;

    @JoinTable(
            name = "person_project",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
//EAGER    -get  data now    LAZY- get data    after  zaprose(po default need to do LAZY)
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Project> project;
}
