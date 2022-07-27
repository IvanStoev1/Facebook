package com.vso;

import com.vso.model.entity.User;
import com.vso.model.services.forgottenPassword.EmailUtilityImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            User user = new User(6);

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.persist(user);

            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
            System.out.println(String.valueOf(user));
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
