package com.vso.model.dao;

import com.vso.model.entity.Friendship;
import com.vso.model.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FriendshipDao {

    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public FriendshipDao() {
    }

    public List<Friendship> getAllFriends(User loggedUser){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Friendship> criteriaQuery = cb.createQuery(Friendship.class);
        Root<Friendship> root = criteriaQuery.from(Friendship.class);

        criteriaQuery.select(root);
        criteriaQuery.where(cb.equal(root.get("requester"), loggedUser));

        Query<Friendship> findAllFriends = session.createQuery(criteriaQuery);
        if (findAllFriends.getResultStream().findAny().isPresent()) {
            return findAllFriends.getResultList();
        }

        session.getTransaction().commit();
        session.close();

        return null;
    }

    public void insertBlockedUser(Friendship blockedUser){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(blockedUser);
        session.getTransaction().commit();
        session.close();
    }

    public void updateFriendshipStatus(long id, String status){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaUpdate<Friendship> cr = cb.createCriteriaUpdate(Friendship.class);
        Root<Friendship> root = cr.from(Friendship.class);

        cr.set(root.get("friendship_status"), status);
        cr.where(cb.equal(root.get("id"), id));

        Query query = session.createQuery(cr);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
