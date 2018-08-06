package examples.hibernate.model.domain;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
