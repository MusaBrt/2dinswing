package io.twodinswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.*;
import java.util.List;

public final class TDFrame extends JFrame {

    private static TDFrame instance;
    public static TDFrame getInstance() {
        if (instance == null) instance = new TDFrame();
        return instance;
    }
    // singularity


    public final static Map<String, List<String>> items = new HashMap<>();

    static {
        /*final String[] args = {"nokta--içiboş--",""};

        for (final String s : args) {
            final String[] splitted = s.split("--");
            final List<String> list = new ArrayList<>(3);
            list.addAll(Arrays.asList(splitted).subList(1, 4));
            items.put(splitted[0], list);
        }*/
    }

    Random random = new Random();

    private TDFrame() {
        add(rootPanel);
        setSize(800,600);
        setTitle("2D In Swing");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createUIComponents();

        entryArea.addFocusListener(new FocusAdapter() {
            boolean fa = true;
            @Override
            public void focusGained(FocusEvent e) {
                if (fa) {
                    entryArea.setText("");
                    fa = !fa;
                }
            }
        });

        renderButton.addActionListener(e -> {
            gp.render((g) -> {

            });
        });
    }

    private JTextArea entryArea;
    private JButton bilgiButton;
    private JButton renderButton;
    private JPanel rootPanel;
    private JPanel editorPanel;
    private GraphicsPane gp;
    private JButton arkaplan;

    private void createUIComponents() {
        gp = new GraphicsPane();
    }

    public void afterInit() {
        System.out.println("sa");
        gp.render((g) -> {
            g.setColor(new Color(255,255,255));
            g.fillRect(0,0, this.getWidth()-1, this.getHeight()-1);
            System.out.println((this.getWidth()-1) + " - " + (this.getHeight()-1));
        });
    }
}