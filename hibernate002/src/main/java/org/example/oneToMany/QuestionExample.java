package org.example.oneToMany;

import org.example.oneToMany.model.Answer;
import org.example.oneToMany.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class QuestionExample {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()                //
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();// inicjalizacja hibernate

        Question q1 = new Question("What is the capital of Germany?");
        Answer a1 = new Answer("Paris",false);
        Answer a2 = new Answer("Berlin",true);
        Answer a3 = new Answer("Madrid",false);
        Answer a4 = new Answer("London",false);

        List<Answer> answers1 = new ArrayList<>();
        answers1.add(a1);
        answers1.add(a2);
        answers1.add(a3);
        answers1.add(a4);
        q1.setAnswers(answers1);
        //session.save(q1);

        Question q2 = new Question("How many people live in USA?");
        Answer b1 = new Answer("300 mln",false);
        Answer b2 = new Answer("250 mln",false);
        Answer b3 = new Answer("180 mln",false);
        Answer b4 = new Answer("330 mln",true);
        List<Answer> answers2 = new ArrayList<>();
        answers2.add(b1);
        answers2.add(b2);
        answers2.add(b3);
        answers2.add(b4);
        q2.setAnswers(answers2);
        //session.save(q2);


        Query query = session.createQuery("FROM Question");
        List<Question> questions = query.list();
        questions.stream().forEach( q-> {
            System.out.println("\n"+q+ ":");
             q.getAnswers().stream().forEach(
                     a-> System.out.println("-"+ a));}
        );

        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
