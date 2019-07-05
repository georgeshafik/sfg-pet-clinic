package guru.springframework.sfgpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gs on 2019-06-24
 */

// Declaring Owner as a database entity for persistence
// Setting the database name as owner
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }


    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    // Here we need a relationship mapping of one to many.
    // We are going to have many pets here.
    // Cascade type here is if delete an owner it will cascade down.
    // If I have an owner and delete the owner the pets of that owner are also deleted.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")

    private Set<Pet> pets = new HashSet<>();

}
