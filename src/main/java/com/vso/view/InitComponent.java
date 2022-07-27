package com.vso.view;

import com.vso.model.service.authentication.AuthenticationServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Objects;

public class InitComponent {

    public InitComponent() {
    }

    public static JButton button(String title, GridBagConstraints c, int gridx, int gridy, int insetL, int insetR) {
        title = Objects.requireNonNullElse(title, ("BUTTON"));
        JButton button = new JButton(title);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, insetL, 0, insetR);
        c.gridx = gridx;
        c.gridy = gridy;
        return button;
    }

    public static JLabel imageLabel(String fileAddress, int width, int height, GridBagConstraints c, int gridx, int gridy, int insetL, int insetR) {
        String myImage;
        myImage = Objects.requireNonNullElse(fileAddress, ("src\\main\\resources\\Upload\\default.png"));
        File fileUrl = new File(myImage);
        if (fileUrl.exists()) {
            java.net.URL imgURL = null;

            try {
                imgURL = fileUrl.toURI().toURL();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


            ImageIcon icon = new ImageIcon(Objects.requireNonNull(imgURL));
            Image image = icon.getImage();
            Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newImage);


            JLabel label = new JLabel(newIcon);
            c.fill = GridBagConstraints.HORIZONTAL;
            c.weightx = 1;
            c.insets = new Insets(0, insetL, 0, insetR); //L = 10, R = 0;
            c.gridx = gridx;
            c.gridy = gridy;
            return label;
        }
        return null;
    }

    public static JLabel txtLabel(String text, GridBagConstraints c, int gridx, int gridy, int insetL, int insetR) {
       text = Objects.requireNonNullElse(text, "LABEL");

        JLabel label = new JLabel(text);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, insetL, 0, insetR);
        c.gridx = gridx;
        c.gridy = gridy;
        return label;
    }

    public static JTextField txtField(GridBagConstraints c, int gridx, int gridy, int insetL, int insetR) {
        JTextField txtField = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, insetL, 0, insetR);
        c.gridx = gridx;
        c.gridy = gridy;

        return txtField;
    }

    public static JToggleButton selectButton(String text, GridBagConstraints c, int gridx, int gridy, int insetL, int insetR){
        text = Objects.requireNonNullElse(text, ("SELECT BUTTON"));
        JToggleButton button = new JToggleButton(text);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(0, insetL, 0, insetR);
        c.gridx = gridx;
        c.gridy = gridy;
        return button;
    }
}
