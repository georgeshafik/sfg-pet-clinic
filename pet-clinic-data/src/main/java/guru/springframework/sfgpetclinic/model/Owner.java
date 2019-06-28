package guru.springframework.sfgpetclinic.model;

import java.util.Set;

/**
 * Created by gs on 2019-06-24
 */
public class Owner extends Person {

    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
