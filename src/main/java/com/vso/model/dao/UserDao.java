package com.vso.model.dao;

import com.vso.model.entity.Photo;
import com.vso.model.entity.Post;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class UserDao {

    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static List<User> getAllUsers(){
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

    public static void setNewEmail(String newEmail) {
        Session session = sessionFactory.openSession();
        long loggedUserId = AuthenticationServiceImpl.getLoggedUser().getId();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaUpdate<User> cr = cb.createCriteriaUpdate(User.class);
        Root<User> root = cr.from(User.class);
        cr.set(root.get("email"), newEmail);
        cr.where(cb.equal(root.get("id"), loggedUserId));
        Query query = session.createQuery(cr);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public static void setLastSentNumber(int lastSentNumber) {
        Session session = sessionFactory.openSession();
        long loggedUserId = AuthenticationServiceImpl.getLoggedUser().getId();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaUpdate<User> cr = cb.createCriteriaUpdate(User.class);
        Root<User> root = cr.from(User.class);
        cr.set(root.get("lastSentNumber"), lastSentNumber);
        cr.where(cb.equal(root.get("id"), loggedUserId));
        Query query = session.createQuery(cr);
        query.executeUpdate();
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

    public static User getUserBy(String email) {
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


    public static void setNewPassword(String newPassword) {
        Session session = sessionFactory.openSession();
        long loggedUserId = AuthenticationServiceImpl.getLoggedUser().getId();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaUpdate<User> cr = cb.createCriteriaUpdate(User.class);
        Root<User> root = cr.from(User.class);
        cr.set(root.get("password"), newPassword);
        cr.where(cb.equal(root.get("id"), loggedUserId));
        Query query = session.createQuery(cr);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
    public String accessUserAvatar(){
        if (AuthenticationServiceImpl.getLoggedUser() == null){
            return null;
        }

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user = session.get(User.class, AuthenticationServiceImpl.getLoggedUser().getId());

        session.getTransaction().commit();
        session.close();

        return user.getAvatarUrl();
    }

    public String accessUserInfo(){
        if (AuthenticationServiceImpl.getLoggedUser() == null){
            return null;
        }

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User user = session.get(User.class, AuthenticationServiceImpl.getLoggedUser().getId());

        session.getTransaction().commit();
        session.close();
        return user.toString();
    }
}