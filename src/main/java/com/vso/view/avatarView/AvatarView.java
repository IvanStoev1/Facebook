package com.vso.view.avatarView;

import com.vso.controller.avatarController.AvatarController;
import com.vso.controller.avatarController.AvatarControllerImpl;
import com.vso.model.entity.Photo;
import com.vso.view.BaseScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class AvatarView extends BaseScreen {

    private AvatarToHomeListener avatarToHomeCallback;
    private AvatarController avatarController;

    public AvatarView(AvatarToHomeListener avatarToHomeCallback) {
        this.avatarController = new AvatarControllerImpl();
        this.avatarToHomeCallback = avatarToHomeCallback;
        setTitle("AVATAR");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    @Override
    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    @Override
    protected void setupComponents() {
        getContentPanel().setLayout(getLayoutManager());

        GridBagConstraints c = new GridBagConstraints();
        JButton btnHome = new JButton("HOME");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, 50, 0, 50);
        c.gridx = 0;
        c.gridy = 0;
        getContentPanel().add(btnHome, c);

        btnHome.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                avatarToHomeCallback.onHomeSelected();
            }
        });
        try {
            int gallerySize = avatarController.getGallerySize();

            for (int i = 0; i < gallerySize; i++) {

                List<Photo> gallery = avatarController.getGallery();

                JScrollBar scrollBar = new JScrollBar(Adjustable.VERTICAL, 30, 40, 0, 60 * i);
                getContentPanel().add(scrollBar, c);

                ImageIcon icon = new ImageIcon(gallery.get(i).getUrl());
                Image image = icon.getImage();
                Image newImage = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newImage);

                JLabel lbPhoto = new JLabel(newIcon);
                c = new GridBagConstraints();
                c.fill = GridBagConstraints.HORIZONTAL;
                c.weightx = 1;
                c.insets = new Insets(0, 100, 0, 100);
                c.gridx = 0;
                c.gridy = 1 + i;
                c.gridwidth = 2;
                getContentPanel().add(lbPhoto, c);

                int finalI = i;
                lbPhoto.addMouseListener(new MouseAdapter() {
                    public void mouseClick(MouseEvent me) {
                        avatarController.setNewAvatar(gallery.get(finalI).getId(), gallery.get(finalI).getUrl());
                    }
                });
            }

        } catch (NullPointerException ignored) {

        }
    }

    public interface AvatarToHomeListener {
        void onHomeSelected();
    }
}
