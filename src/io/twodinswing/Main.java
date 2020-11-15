package io.twodinswing;

import javax.swing.*;

public final class Main {

    static {
        System.setProperty("awt.useSystemAAFontSettings","on");
        System.setProperty("swing.aatext", "true");
    }

    public static void main(String[] args) {

        String laf = System.getProperty("os.name").toLowerCase().contains("win")
                ? UIManager.getSystemLookAndFeelClassName()
                : "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
        try {
            UIManager.setLookAndFeel(laf);
        } catch (Throwable t) {
            t.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            TDFrame f = TDFrame.getInstance();
            f.setVisible(true);
            f.afterInit();
        });
    }

}