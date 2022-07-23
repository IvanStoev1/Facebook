package com.vso.model.dao;

import com.vso.model.entity.Photo;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationService;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhotoDao {

    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public PhotoDao() {
    }

    public List<Photo> selectPhotosByUserId(User user) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Photo> cr = cb.createQuery(Photo.class);
        Root<Photo> root = cr.from(Photo.class);

        cr.select(root);
        cr.where(cb.equal(root.get("user_id"), user));

        Query<Photo> query = session.createQuery(cr);
        session.getTransaction().commit();
        session.close();

        return query.getResultList();
    }

    //@Transactional
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

    public int getGallerySize(User user){
        return selectPhotosByUserId(user).size();
    }
}
