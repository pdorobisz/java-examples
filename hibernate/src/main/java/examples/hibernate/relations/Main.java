package examples.hibernate.relations;

import examples.hibernate.config.Config;
import examples.hibernate.relations.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

@SpringBootApplication
@Import({Config.class})
public class Main implements CommandLineRunner {

    @Autowired
    private SessionFactory sessionFactory;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Session session = sessionFactory.openSession();

        Question question = new Question("Co to jest?");
        Answer answer = new Answer("To jest pilka");
        Vote vote = new Vote(true);

        // Trzeba zapisac relacje z obydwu stron. Przypisanie tylko do answer wystarczy zeby relacja zostala zapisana do bazy danych,
        // ale w tej sesji hibernate nie bedzie "widzial", ze question ma przypisane answer.
        answer.setQuestion(question);
        question.setAnswers(Arrays.asList(answer));
        answer.setVotes(Arrays.asList(vote));

        session.persist(answer);
        session.persist(question); // mozna pominac gdy odpowiednie CASCADE przy @ManyToOne na polu Answer#question
        session.persist(vote);

        // ManyToMany
        Company company = new Company("Firma 1");
        Employee employee = new Employee("Janek");
        company.setEmployees(Arrays.asList(employee));
        employee.setCompanies(Arrays.asList(company));

        session.persist(company);
        session.persist(employee);

        session.flush();
        session.close();
    }
}
