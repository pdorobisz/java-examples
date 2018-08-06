package examples.hibernate.relations.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "answer")
public class Answer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    // strona do ktorej nalezy relacja posiada JoinColumn
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    // Jednostronna relacja OneToMany, wlascicielem jest answer (nie ma "mappedBy").
    // Powstaje dodatkowa tabela answer_vote
    @OneToMany
    private List<Vote> votes;

    public Answer(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
}
