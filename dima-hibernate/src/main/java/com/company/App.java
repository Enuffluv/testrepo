package com.company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                new Configuration().configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Department.class)
                        .addAnnotatedClass(Employee.class)
                        .buildSessionFactory();
        Users user1 = new Users("Dima");
        Users user2 = new Users("Oleg");

        Posts post1 = new Posts("odin", 12);
        Posts post2 = new Posts("dva", 11);
        Posts post3 = new Posts("tri", 10);
        Posts post4 = new Posts("chetyre", 9);
        Posts post5 = new Posts("pyat", 8);

        user1.getPosts().add(post1);
        user1.getPosts().add(post3);
        user2.getPosts().add(post2);
        user2.getPosts().add(post4);
        user2.getPosts().add(post5);


        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.save(user1);
        session.save(user2);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
