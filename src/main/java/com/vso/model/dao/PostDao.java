package com.vso.model.dao;

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

public class PostDao {

    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public PostDao() {
    }

    public List<Post> selectPostsByUserId(User thisUser) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Post> cr = cb.createQuery(Post.class);
        Root<Post> root = cr.from(Post.class);

        cr.select(root).orderBy(cb.desc(root.get("id")));
        cr.where(cb.equal(root.get("user_id"), thisUser.getId()));

        Query<Post> query = session.createQuery(cr);
        session.getTransaction().commit();
        session.close();

        return query.getResultList();
    }
}
