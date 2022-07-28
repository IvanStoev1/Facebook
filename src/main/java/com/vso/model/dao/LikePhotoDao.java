package com.vso.model.dao;

import com.vso.model.entity.Likephoto;
import com.vso.model.entity.Photo;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class LikePhotoDao {

    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public LikePhotoDao() {
    }

    public List<Likephoto> getLikesForThisPicture(Photo photo) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Likephoto> criteriaQuery = cb.createQuery(Likephoto.class);
        Root<Likephoto> root = criteriaQuery.from(Likephoto.class);

        criteriaQuery.select(root);
        criteriaQuery.where(cb.equal(root.get("photo"), photo));

        Query<Likephoto> findAllLikephoto = session.createQuery(criteriaQuery);
        if (findAllLikephoto.getResultStream().findAny().isPresent()) {
            return findAllLikephoto.getResultList();
        }

        session.getTransaction().commit();
        session.close();

        return null;
    }

    public int countLikes(Photo photo) {
        return getLikesForThisPicture(photo).size();
    }

    public void insertNewPhotoLike(Likephoto likephoto) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(likephoto);
        session.getTransaction().commit();
        session.close();
    }
}