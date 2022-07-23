package com.vso.view.profileView;

import com.vso.controller.photoController.PhotoController;
import com.vso.controller.photoController.PhotoControllerImpl;
import com.vso.controller.userController.UserController;
import com.vso.controller.userController.UserControllerImpl;
import com.vso.model.entity.Photo;
import com.vso.model.entity.User;
import com.vso.model.service.authentication.AuthenticationServiceImpl;
import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class GallerySection extends BaseScreen {

    private static final PhotoController photoController = new PhotoControllerImpl();
    private static final UserController userController = new UserControllerImpl();

    public GallerySection() {

    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    public static void setupGallery(int gridYInitial, JPanel controlPanel) {

        try {
            int counter = 0;
            int gridXInitial = 0;

            for (Photo photo : gallery()) {

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

                int id = photo.getId();

                lbPhoto.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        LikeAndCommentSection likeAndCommentSection = new LikeAndCommentSection();
                        likeAndCommentSection.makeVisible();
                        System.out.println("Yay you clicked me + " + id);
                    }
                });
            }
        } catch (NullPointerException ignored) {

        }
    }

    public static int getLastYgrid(){
        int printedComponents = gallery().size();
        if (printedComponents % 3 == 0){
            return  printedComponents / 3;
        } return (printedComponents / 3) + 1;
    }

    private static List<Photo> gallery() throws NullPointerException {
        User loggedUser = AuthenticationServiceImpl.getLoggedUser();
        return photoController.showUserPhotos(loggedUser);
    }

    @Override
    protected void setupComponents() {

    }
}
