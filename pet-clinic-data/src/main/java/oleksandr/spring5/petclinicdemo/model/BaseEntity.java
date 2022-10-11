package oleksandr.spring5.petclinicdemo.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    private Long id; //hibernate recommends using Boxed types

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
