package examples.hibernate.relations.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vote")
public class Vote implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private boolean isOk;

    public Vote(boolean isOk) {
        this.isOk = isOk;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setIsOk(boolean isOk) {
        this.isOk = isOk;
    }
}
