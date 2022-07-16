package com.vso.model.service.avatarUpdateService;

import com.vso.model.dao.PhotoDao;
import com.vso.model.dao.UserDao;
import com.vso.model.entity.Photo;
import com.vso.model.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateAvatarServiceImpl implements UpdateAvatarService {

    private final PhotoDao photoDao;

    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public UpdateAvatarServiceImpl() {
        this.photoDao = new PhotoDao();
    }

    private String selectAvatarFromUploadedPhotos(int loggedUser, long selectedPhotoId){
        String newAvatarUrl = null;
        List<Photo> userPhotos = photoDao.selectPhotosByUserId(loggedUser);
        for (Photo photo : userPhotos) {
            if (photo.getId() == selectedPhotoId){
                newAvatarUrl = photo.getUrl();
            }
        }
        return newAvatarUrl;
    }

    @Override
    public void updateAvatarOrCoverPhoto(int loggedUserId, long selectedPhotoId, String oldAvatarUrl){

        String newAvatarPhoto = selectAvatarFromUploadedPhotos(loggedUserId, selectedPhotoId);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaUpdate<User> cr = cb.createCriteriaUpdate(User.class);
        Root<User> root = cr.from(User.class);

        cr.set(root.get(oldAvatarUrl), newAvatarPhoto);
        cr.where(cb.equal(root.get("id"), loggedUserId));

        session.getTransaction().commit();
        session.close();
    }


}
