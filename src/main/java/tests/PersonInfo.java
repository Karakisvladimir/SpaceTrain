package tests;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "person_info")
public class PersonInfo {
@Id
@Column(name = "person_id")
private long personId;

@Column(name = "person_name")
private String name;


}
