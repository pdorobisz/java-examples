package examples.hibernate.model.domain;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    @Version
    protected long version;

    public int hashCode() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        else if (id != 0) {
            return id == ((BaseEntity) obj).id;
        } else
            return super.equals(obj);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
