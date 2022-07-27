package com.vso.model.service;

import com.vso.model.dao.UserDao;
import com.vso.model.entity.User;
import com.vso.view.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteAccount {

    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public DeleteAccount() {

    }

    public void deleteAccount(String email, String password) {
        User user = UserDao.getUserBy(email);
        Session session = sessionFactory.openSession();
        if (user != null && user.getPassword().equals(password)) {
            user.setProfileStatus("deleted");
            session.beginTransaction();
            session.merge(user);
            session.getTransaction().commit();
            session.close();
        } else {
            new Message("Wrong password or email");
        }
    }
}
