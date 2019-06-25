package guru.springframework.sfgpetclinic.model;

import java.io.Serializable;

/**
 * Created by gs on 2019-06-25
 */
public class BaseEntity implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
