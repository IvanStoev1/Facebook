package com.vso.view.uploadPhotoView;
import com.vso.controller.UploadPhotoController;
import com.vso.view.BaseScreen;
import com.vso.view.Navigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class UploadView extends JFrame {

    private final UploadPhotoController uploadPhotoController = new UploadPhotoController();

    public UploadView() throws IOException {
        JFrame frame = new JFrame();
        setTitle("Uploader");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setupComponents(frame);
    }

    protected GridBagLayout getLayoutManager() {
        return new GridBagLayout();
    }

    protected void setupComponents(Frame frame) {
        setLayout(getLayoutManager());

        JLabel lbService = new JLabel("Image uploader");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 50, 0, 50);
        add(lbService, c);

        JTextField txtPhotoDescription = new JTextField();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, 50, 0, 50);
        c.gridx = 0;
        c.gridy = 1;
        add(txtPhotoDescription, c);

        JButton btnUpload = new JButton("Upload image...");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, 50, 0, 50);
        c.gridx = 0;
        c.gridy = 2;
        add(btnUpload, c);

        JButton btnSave = new JButton("Save");
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, 50, 0, 50);
        c.gridx = 0;
        c.gridy = 3;
        add(btnSave, c);

        JLabel lbMessage = new JLabel();
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(0, 50, 0, 50);
        add(lbMessage, c);

        btnUpload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.addChoosableFileFilter(new FileChooserFilter());
                fileChooser.setAcceptAllFileFilterUsed(false);

                int option = fileChooser.showOpenDialog(frame);
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
                try {
                    String photoDescription = txtPhotoDescription.toString();
                    String imageSource = lbMessage.toString();
                    uploadPhotoController.uploadPhoto(photoDescription, imageSource);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
