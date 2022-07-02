package com.vso;

<<<<<<< HEAD
import com.vso.model.entity.Friendships;
import com.vso.model.entity.Photos;
import com.vso.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
=======
import com.vso.controller.AuthController;
import com.vso.model.service.authentication.AuthenticationService;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.model.service.login.LoginSession;
import com.vso.view.AuthView;
>>>>>>> 656a14378d066b2a7af27ecaa4daf1228bdaf9ae

public class Main {

    public static void main(String[] args) {
<<<<<<< HEAD
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
=======

        AuthenticationService authentication = new AuthenticationServiceImpl();
        new LoginSession(authentication, new AuthController(authentication, new AuthView())).initSession();
>>>>>>> 656a14378d066b2a7af27ecaa4daf1228bdaf9ae
    }
}
