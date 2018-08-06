package examples.hibernate.relations.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    // Wlascicielem relacji jest company. Gdyby nie bylo "mappedBy" to bylaby to niezalezna relacja, ktora bylaby
    // zapisywana w employee_company.
    @ManyToMany(mappedBy = "employees")
    private List<Company> companies;

    public Employee(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
