package com.vso.model.dao;

import com.vso.model.entity.Photo;
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

    public String accessUserAvatar(User userId){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);

        criteriaQuery.select(root);
        criteriaQuery.where(cb.equal(root.get("id"), userId));

        Query<User> findUserAvatar = session.createQuery(criteriaQuery);
        if (findUserAvatar.getResultStream().findFirst().isPresent()) {
            User user = findUserAvatar.getResultStream().findFirst().get();
            return user.getAvatarUrl();
        }
        session.getTransaction().commit();
        session.close();
        return null;
    }

    public String accessUserInfo(User userId){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Photo> criteriaQuery = cb.createQuery(Photo.class);
        Root<Photo> root = criteriaQuery.from(Photo.class);

        criteriaQuery.select(root);
        criteriaQuery.where(cb.equal(root.get("user_id"), userId));

        Query<Photo> findInfo = session.createQuery(criteriaQuery);
        if (findInfo.getResultStream().findFirst().isPresent()) {
            Photo photo = findInfo.getResultStream().findFirst().get();
            return photo.getUrl();
        }
        session.getTransaction().commit();
        session.close();
        return null;
    }
}