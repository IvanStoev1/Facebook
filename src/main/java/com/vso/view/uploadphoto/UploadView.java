package com.vso.view.uploadphoto;

import com.vso.controller.photo.PhotoController;
import com.vso.view.BaseScreen;
import com.vso.view.InitComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;

public class UploadView extends BaseScreen {

    private final PhotoController photoController = new PhotoController();
    private final UploadToHomeListener uploadToHomeCallback;

    public UploadView(UploadToHomeListener uploadToHomeCallback) {
        this.uploadToHomeCallback = uploadToHomeCallback;
        setTitle("Uploader");
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

        JLabel lbService = InitComponent.txtLabel("Image uploader", c, 0, 0, 10 , 0);
        getContentPanel().add(lbService, c);

        JTextField txtPhotoDescription = InitComponent.txtField(c,0,1,50,50);
        getContentPanel().add(txtPhotoDescription, c);

        JButton btnUpload = InitComponent.button("Upload image...", c, 0, 2, 50, 50);
        getContentPanel().add(btnUpload, c);

        JButton btnSave = InitComponent.button("Save", c, 0, 3, 50, 50);
        getContentPanel().add(btnSave, c);

        JLabel lbMessage = InitComponent.txtLabel("", c, 0, 4, 50, 50);
        getContentPanel().add(lbMessage, c);

        JButton btnHome = InitComponent.button("HOME", c, 0, 5, 50, 50);
        getContentPanel().add(btnHome, c);

        getContentPanel().getRootPane().setDefaultButton(btnSave);

        btnUpload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.addChoosableFileFilter(new FileChooserFilter());
                fileChooser.setAcceptAllFileFilterUsed(false);

                int option = fileChooser.showOpenDialog(getContentPanel());
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    Path path = file.toPath();
                    lbMessage.setText(path.toString());
                    System.out.println(path);
                } else {
                    lbMessage.setText("Open command canceled");
                }
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String photoDescription = txtPhotoDescription.getText();
                String imageSource = lbMessage.getText();
                photoController.uploadPhoto(photoDescription, imageSource);
                lbMessage.setText("");
                txtPhotoDescription.setText("");
            }
        });

        btnHome.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                uploadToHomeCallback.onHomeSelected();
            }
        });
    }

    public interface UploadToHomeListener {
        void onHomeSelected();
    }

}
