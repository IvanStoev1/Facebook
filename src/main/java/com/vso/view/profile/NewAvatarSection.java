package com.vso.view.profile;

import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;

import javax.swing.*;
import java.awt.*;

public class NewAvatarSection extends BaseScreen {

    private final BackToProfileListener backToProfileCallback;
    private final GallerySection gallerySection = new GallerySection();

    public NewAvatarSection(BackToProfileListener backToProfileCallback) {
        this.backToProfileCallback = backToProfileCallback;
        setTitle("MY PROFILE");
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

        JButton backToProfile = InitComponent.button("BACK TO PROFILE", c, 0, 0, 10, 0);
        getContentPanel().add(backToProfile, c);

        GallerySection.setupGallery(1, getContentPanel());

        backToProfile.addActionListener(e -> {
            backToProfileCallback.onBackToProfileSelected();
        });
    }

    public interface BackToProfileListener {
        void onBackToProfileSelected();
    }
}
