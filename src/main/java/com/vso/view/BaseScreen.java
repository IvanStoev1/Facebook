package com.vso.view;

import javax.swing.*;
import java.awt.*;

public abstract class BaseScreen extends JFrame{
    private static JPanel contentPanel;

    public BaseScreen() {
        contentPanel = new JPanel();
        contentPanel.setLayout(getLayoutManager());
        add(contentPanel);
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        add(scrollPane);
        setSize(1000, 780);
        getContentPanel().setBackground(Color.white);
        setupComponents();
        setLocationRelativeTo(null);
    }

    protected abstract LayoutManager getLayoutManager();

    protected static JPanel getContentPanel() {
        return contentPanel;
    }

    protected abstract void setupComponents();

    public void makeVisible() {
        setVisible(true);
        repaint();
    }

    public void hideScreen() {
        setVisible(false);
    }
}