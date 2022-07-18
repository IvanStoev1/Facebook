package com.vso.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class BaseScreen extends JFrame{
    private final JPanel contentPanel;

    public BaseScreen() {
        contentPanel = new JPanel();
        contentPanel.setLayout(getLayoutManager());
        add(contentPanel);
        setSize(500,500);
        setupComponents();
        getContentPanel().setBackground(Color.white);
        setLocationRelativeTo(null);
    }

    protected abstract LayoutManager getLayoutManager();

    protected JPanel getContentPanel() {
        return contentPanel;
    }

    protected abstract void setupComponents();

    public void makeVisible() {
        setVisible(true);
    }

    public void hideScreen() {
        setVisible(false);
    }
}