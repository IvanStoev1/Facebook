package com.vso;

import com.vso.model.entity.Friendships;
import com.vso.model.entity.Photos;
import com.vso.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            User user = new User(6);
          //  Friendships friendships = new Friendships(user,user.getId(), 2,"friends");
            Photos photos = new Photos( user.getId(), "asd","asdf");

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.persist(photos);

            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
            System.out.println(String.valueOf(photos));
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
