package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gs on 2019-06-24
 */
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    @Column(name = "name")
    private String name;

    // Many pets can be owned by the same owner
    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    // Many pets can be owned by the same owner
    @ManyToOne
    @JoinColumn(name = "owner_id") // this tells JPA how to perform the mapping basically
    private Owner owner;           // copy owner_id from the owner table to owner column of the pets table

    @Column(name = "birth_date")
    private LocalDate birthdate;

    // A pet can visit a vet many times
    // A given pet can have many visits - a set of visits
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }
}
