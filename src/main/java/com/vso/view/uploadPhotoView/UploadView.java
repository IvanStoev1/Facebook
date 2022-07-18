package com.vso.view.uploadPhotoView;

import com.vso.controller.uploadPhotoController.UploadPhotoControllerImpl;
import com.vso.view.BaseScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;

public class UploadView extends BaseScreen {

    private final UploadPhotoControllerImpl uploadPhotoController = new UploadPhotoControllerImpl();
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

        JLabel lbService = new JLabel("Image uploader");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 50, 0, 50);
        getContentPanel().add(lbService, c);

        JTextField txtPhotoDescription = new JTextField();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, 50, 0, 50);
        c.gridx = 0;
        c.gridy = 1;
        getContentPanel().add(txtPhotoDescription, c);

        JButton btnUpload = new JButton("Upload image...");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, 50, 0, 50);
        c.gridx = 0;
        c.gridy = 2;
        getContentPanel().add(btnUpload, c);

        JButton btnSave = new JButton("Save");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, 50, 0, 50);
        c.gridx = 0;
        c.gridy = 3;
        getContentPanel().add(btnSave, c);

        JLabel lbMessage = new JLabel();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0, 50, 0, 50);
        getContentPanel().add(lbMessage, c);

        JButton btnHome = new JButton("HOME");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, 50, 0, 50);
        c.gridx = 0;
        c.gridy = 5;
        getContentPanel().add(btnHome, c);

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
                uploadPhotoController.uploadPhoto(photoDescription, imageSource);
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
