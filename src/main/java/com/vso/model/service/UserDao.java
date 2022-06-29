package com.vso.model.service;

import com.vso.model.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;


public class UserDao {

    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


    public UserDao() {
    }

    public List<User> getAllUsers(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);
        Root<User> root = cr.from(User.class);
        cr.select(root);

        Query<User> query = session.createQuery(cr);
        session.getTransaction().commit();

        return query.getResultList();

    }

    public static void addUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(user);

        session.getTransaction().commit();
    }

    public boolean userExists(String email, String password){
        Optional<User> existingUser = getAllUsers()
                .stream()
                .filter(user -> user.getEmail().equals(email)
                        && user.getPassword().equals(password))
                .findFirst();

        return existingUser.isPresent();

    }

    public User getObject(String object) {
        Optional<User> first =
                getAllUsers()
                        .stream()
                        .filter(user -> user.getEmail().equals(object))
                        .findFirst();

        return first.orElse(null);
    }

}