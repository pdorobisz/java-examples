package examples.hibernate.relations.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "question")
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    public Question(String title) {
        this.title = title;
    }

    // mappedBy oznacza, ze ta relacja nalezy do answer (answer posiada klucz obcy do question).
    // Gdyby go nie bylo to powstalaby osobna tabela laczaca question i answer.
    // Przy dwustronnej relacji zazwyczaj druga strona (ManyToOne) jest wlascicielem relacji.
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "question")
    private List<Answer> answers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
