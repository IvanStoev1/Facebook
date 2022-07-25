package com.vso.model.dao;

import com.vso.model.entity.Post;
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

    public List<User> getAllUsers(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);
        Root<User> root = cr.from(User.class);
        cr.select(root);

        Query<User> query = session.createQuery(cr);
        List<User> resultList = query.getResultList();
        session.getTransaction().commit();
        session.close();

        return resultList;
    }

    public static void addUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }

    public boolean userExists(String email){
        Optional<User> existingUser = getAllUsers()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();

        return existingUser.isPresent();

    }

    public User getUserBy(String email) {
        Optional<User> first =
                getAllUsers()
                        .stream()
                        .filter(user -> user.getEmail().equals(email))
                        .findFirst();

        return first.orElse(null);
    }

    public void addPost(Post post) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(post);
        session.getTransaction().commit();
        session.close();
    }
}