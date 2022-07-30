package com.vso.model.dao;

import com.vso.model.entity.Photo;
import com.vso.model.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PhotoDao {

    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public PhotoDao() {
    }

    public List<Photo> selectPhotosByUserId(User user) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Photo> criteriaQuery = cb.createQuery(Photo.class);
        Root<Photo> root = criteriaQuery.from(Photo.class);

        criteriaQuery.select(root);
        criteriaQuery.where(cb.equal(root.get("user"), user));

        Query<Photo> findAllPhotos = session.createQuery(criteriaQuery);
        if (findAllPhotos.getResultStream().findAny().isPresent()) {
            return findAllPhotos.getResultList();
        }

        session.getTransaction().commit();
        session.close();

        return null;
    }

    public Integer getLast() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Photo> criteriaQuery = cb.createQuery(Photo.class);
        Root<Photo> root = criteriaQuery.from(Photo.class);

        criteriaQuery
                .select(root)
                .orderBy(cb.desc(root.get("id")));

        Query<Photo> findAllPhotos = session.createQuery(criteriaQuery);

        if (findAllPhotos.getResultStream().findFirst().isPresent()) {
            Photo photo = findAllPhotos.getResultStream().findFirst().get();
            return photo.getId();
        }

        session.getTransaction().commit();
        session.close();

        return 0;
    }

    public void insertNewPhotoInDb(Photo newPhoto) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newPhoto);
        session.getTransaction().commit();
        session.close();
    }

    public void likePost(User user, Photo photo) {
        Set<User> likes;
        if (photo.getLikes() != null)
            likes = photo.getLikes();
        else {
            likes = new HashSet<>();
        }
        likes.add(user);
        photo.setLikes(likes);
    }

}
