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

    public static void deleteAccount(String email, String password) {

    }
}
