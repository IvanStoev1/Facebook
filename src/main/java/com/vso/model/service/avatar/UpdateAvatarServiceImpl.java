package com.vso.model.service.avatar;

import com.vso.model.dao.PhotoDao;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateAvatarServiceImpl implements UpdateAvatarService {

    private final PhotoDao photoDao;
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


    public UpdateAvatarServiceImpl() {
        this.photoDao = new PhotoDao();
    }

    @Override
    public void updateAvatarPhoto(String newAvatarPhotoUrl){
        long loggedUserId = AuthenticationServiceImpl.getLoggedUser().getId();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaUpdate<User> cr = cb.createCriteriaUpdate(User.class);
        Root<User> root = cr.from(User.class);

        cr.set(root.get("avatarUrl"), newAvatarPhotoUrl);
        cr.where(cb.equal(root.get("id"), loggedUserId));

        Query query = session.createQuery(cr);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

}