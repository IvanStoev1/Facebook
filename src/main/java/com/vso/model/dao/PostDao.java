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

public class PostDao {

    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public PostDao() {
    }

    public List<Post> selectPostsByUserId(User thisUser) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Post> createQuery = cb.createQuery(Post.class);
        Root<Post> root = createQuery.from(Post.class);

        createQuery.select(root).orderBy(cb.desc(root.get("date")));;
        //createQuery.where(cb.equal(root.get("user_id"), thisUser.getId()));

        Query<Post> query = session.createQuery(createQuery);
        if (query.getResultStream().findAny().isPresent()) {
            return query.getResultList();
        }
        session.getTransaction().commit();
        session.close();

        return null;
    }
}