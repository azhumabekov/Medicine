package java15.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name = "pharmacies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    String name;
    String address;

    @ManyToMany
    List<Medicine> medicines;

    @OneToMany
    List<Worker> workers;
}
