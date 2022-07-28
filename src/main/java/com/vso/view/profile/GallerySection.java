package com.vso.view.profile;

import com.vso.controller.photo.PhotoController;
import com.vso.model.entity.Photo;
import com.vso.model.entity.User;
import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;
import com.vso.view.Navigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class GallerySection extends BaseScreen {

    private final Navigation navigation;
    private static final PhotoController photoController = new PhotoController();
    private User user;

    public GallerySection(User user, Navigation navigation) {
        this.navigation = navigation;
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    public void setupGallery(int gridYInitial, JPanel controlPanel, User user) {
        Navigation navigation = new Navigation();
        try {
            int counter = 0;
            int gridXInitial = 0;

            for (Photo photo : gallery(user)) {

                GridBagConstraints c;
                c = new GridBagConstraints();
                counter++;

                JLabel lbPhoto = InitComponent.imageLabel(photo.getUrl(), 300, 200, c, gridXInitial, gridYInitial, 10, 0);
                assert lbPhoto != null;
                controlPanel.add(lbPhoto, c);

                if (counter == 3) {
                    counter = 0;
                    gridYInitial++;
                    gridXInitial = 0;
                } else {
                    gridXInitial++;
                }

                Photo newAvatar = photo;

                lbPhoto.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new LikePhotoSection(newAvatar, navigation, user);
                        //new LikeCommentPost(newAvatar, navigation, user);
                    }
                });
            }
        } catch (NullPointerException ignored) {

        }
    }

    public int getLastYgrid(User user) {

        if (gallery(user) != null) {
            int printedComponents = gallery(user).size();
            if (printedComponents % 3 == 0) {
                return printedComponents / 3;
            }
            return (printedComponents / 3) + 1;
        } else {
            return 1;
        }
    }

    private List<Photo> gallery(User user) throws NullPointerException {
        return photoController.showUserPhotos(user);
    }

    @Override
    protected void setupComponents() {

    }
}
