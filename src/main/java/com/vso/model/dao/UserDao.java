package com.vso.model.dao;

import com.vso.model.entity.Photo;
import com.vso.model.entity.Post;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.function.Predicate.not;

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

    public String accessUserAvatar(User user){
        if (user == null){
            return null;
        }

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User userAvatar = session.get(User.class, user.getId());

        session.getTransaction().commit();
        session.close();

        return userAvatar.getAvatarUrl();
    }

    public String accessUserInfo(User user){
        if (user == null){
            return null;
        }

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        User userInfo = session.get(User.class, user.getId());

        session.getTransaction().commit();
        session.close();
        return userInfo.toString();
    }

    public static List<Post> getPostsBy(User user) {
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

        return Objects.requireNonNull(resultList.stream()
                        .filter(user1 -> user1.getId() == user.getId())
                        .findFirst()
                        .orElse(null))
                .getPosts();
    }

    public static List<Photo> getPhotosBy(User user) {
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

        return Objects.requireNonNull(resultList.stream()
                        .filter(user1 -> user1.getId() == user.getId())
                        .findFirst()
                        .orElse(null))
                .getPhotos();
    }
}