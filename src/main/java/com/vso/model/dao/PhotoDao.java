package com.vso.model.dao;

import com.vso.model.entity.Photo;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PhotoDao {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public PhotoDao() {
    }

    public List<Photo> selectPhotosByUserId(int loggedUser) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Photo> cr = cb.createQuery(Photo.class);
        Root<Photo> root = cr.from(Photo.class);

        cr.select(root);
        cr.where(cb.equal(root.get("user_id"), loggedUser));

        Query<Photo> query = session.createQuery(cr);
        session.getTransaction().commit();
        session.close();

        return query.getResultList();
    }

    private List<Photo> getListOftId(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Photo> cr = cb.createQuery(Photo.class);
        Root<Photo> root = cr.from(Photo.class);

        cr.select(cb.construct(Photo.class, root.get("id")));
        cr.orderBy(cb.desc(root.get("id")));

        Query<Photo> query = session.createQuery(cr);
        session.getTransaction().commit();
        session.close();
        return query.getResultList();

    }

    public long getLastId(){
        long photoIdFromResultList = getListOftId().stream().mapToLong(Photo::getId).findFirst().getAsLong();

        if (photoIdFromResultList == 0){
            photoIdFromResultList = 1;
        }
        return photoIdFromResultList;
    }

    public void insertNewPhotoInDb(Photo newPhoto){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newPhoto);
        session.getTransaction().commit();
        session.close();

    }
}
