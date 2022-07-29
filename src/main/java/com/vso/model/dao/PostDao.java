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

import java.util.*;
import java.util.stream.Collectors;

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

        createQuery.select(root).orderBy(cb.desc(root.get("date")));
        ;
        createQuery.where(cb.equal(root.get("user"), thisUser));

        Query<Post> query = session.createQuery(createQuery);
        if (query.getResultStream().findAny().isPresent()) {
            return query.getResultList();
        }
        session.getTransaction().commit();
        session.close();

        return null;
    }

    public static List<Post> getOrderedPosts() {
        List<Post> requestedPosts = Objects.requireNonNull(
                        FriendshipDao.getAllFriends(AuthenticationServiceImpl.getLoggedUser()))
                .stream()
                .flatMap(friendship -> friendship.getRequested().getPosts().stream())
                .collect(Collectors.toList());

        List<Post> requestersPosts = Objects.requireNonNull(
                        FriendshipDao.getAllFriends(AuthenticationServiceImpl.getLoggedUser()))
                .stream()
                .flatMap(friendship -> friendship.getRequester().getPosts().stream())
                .collect(Collectors.toList());

        requestedPosts.addAll(requestersPosts);
        Set<Post> allUnique = new HashSet<>(requestedPosts);
        ArrayList<Post> uniqueList = new ArrayList<>(allUnique);
        Collections.sort(uniqueList);
        Collections.reverse(uniqueList);
        return uniqueList;
    }

    public void likePost(User user, Post post) {
        Set<User> likes;
        if (post.getLikes() != null)
            likes = post.getLikes();
        else {
            likes = new HashSet<>();
        }
        likes.add(user);
        post.setLikes(likes);
    }
}
