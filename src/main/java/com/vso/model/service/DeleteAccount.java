package com.vso.model.service;

import com.vso.model.dao.UserDao;
import com.vso.model.entity.Friendship;
import com.vso.model.entity.User;
import com.vso.view.Message;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DeleteAccount {

    UserDao database;
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public DeleteAccount() {
        this.database = new UserDao();

    }

    public void deleteAccount(User user) {
        String status = "deleted";
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaUpdate<User> cr = cb.createCriteriaUpdate(User.class);
        Root<User> root = cr.from(User.class);

        cr.set(root.get("profileStatus"), status);
        cr.where(cb.equal(root.get("id"), user.getId()));
        System.out.println(status);

        Query query = session.createQuery(cr);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();

    }
}
