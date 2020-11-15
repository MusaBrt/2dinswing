package io.twodinswing;

import javax.swing.*;
import java.awt.*;

public class GraphicsPane extends JPanel {

    public GraphicsPane() {
        super();
        setLayout(null);
    }

    private Picasso pika;

    @Override
    protected void paintComponent(Graphics gg) {
        System.out.println("asd");
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (pika == null) return;
        pika.run(g);
    }

    public void render(Picasso pikas) {
        pika = pikas;
        repaint();
    }
}