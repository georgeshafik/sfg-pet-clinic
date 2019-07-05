package guru.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by gs on 2019-06-24
 */
// We will never be working with a Person POJO as we will always be inheriting from it
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {


    public Person(Long id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Setting the column name in the database by default Hibernate will use snake case
    // which is the naming convention strategy of placing an underscore i.e first_name
    // so we are being a little redundant here
    @Column(name = "first_name")
    private String firstName;

    // Setting the column name in the database
    @Column(name = "last_name")
    private String lastName;


}
