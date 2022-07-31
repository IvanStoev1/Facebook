package com.vso.view;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

public class Message extends AbstractBorder {

    private final int thickness;
    private final int radii;
    private final int pointerSize;
    private final Insets insets;
    private final BasicStroke stroke;
    private final int strokePad;
    private int pointerPad;
    RenderingHints hints;

    public Message(String content) {
        this(4, 8, 7);

        JTextField o = new JTextField(content);
        o.setBorder(new Message(2, 4, 0));
        JOptionPane.showMessageDialog(null, o);
    }

    private Message(int thickness, int radii, int pointerSize) {
        this.thickness = thickness;
        this.radii = radii;
        this.pointerSize = pointerSize;

        stroke = new BasicStroke(thickness);
        strokePad = thickness / 2;

        hints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int pad = radii + strokePad;
        int bottomPad = pad + pointerSize + strokePad;
        insets = new Insets(pad, pad, bottomPad, pad);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return insets;
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        return getBorderInsets(c);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g;
        int bottomLineY = height - thickness - pointerSize;

        RoundRectangle2D.Double bubble = new RoundRectangle2D.Double(strokePad, strokePad, width - thickness,
                bottomLineY, radii, radii);

        Polygon pointer = new Polygon();
        pointer.addPoint(strokePad + radii + pointerPad, bottomLineY);
        pointer.addPoint(strokePad + radii + pointerPad + pointerSize, bottomLineY);
        pointer.addPoint(strokePad + radii + pointerPad + (pointerSize / 2), height - strokePad);

        Area area = new Area(bubble);
        area.add(new Area(pointer));

        g2.setRenderingHints(hints);

        Area spareSpace = new Area(new Rectangle(0, 0, width, height));
        spareSpace.subtract(area);
        g2.setClip(spareSpace);
        g2.clearRect(0, 0, width, height);
        g2.setClip(null);

        g2.setStroke(stroke);
        g2.draw(area);
    }
}