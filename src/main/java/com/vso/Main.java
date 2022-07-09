package com.vso;


import com.vso.model.entity.Post;
import com.vso.model.entity.User;
import com.vso.model.service.DeleteService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {

    public static void main(String[] args) {

        DeleteService likePostService = new DeleteService();
        User user = new User("user1@abv.bg","123411", "User1", 27);
        User user2 = new User("user2@abv.bg","12345678", "User2", 30);

        Post post = new Post("This is my first post", user);
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.persist(user);
            session.persist(user2);
            session.persist(post);

            likePostService.likePost(user2, post);

            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        }catch (Exception e){
            System.out.println(e);
        }


    }
}
