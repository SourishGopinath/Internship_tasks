package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.awt.Font;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;

public class WordCounterApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(WordCounterApp::GUI);
    }

    private static void GUI() {
        JFrame f = new JFrame("Word Counter");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 300);
        f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Word Count: ");
        label.setAlignmentX(0.5f);
        f.add(label);

        JTextArea t = new JTextArea(10, 40);
        t.setLineWrap(true);
        JScrollPane s = new JScrollPane(t, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        f.add(s);

        JButton cb = getjButton();

        f.add(cb);

        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String i = t.getText();
                int wt = countWords(i);
                label.setText("Word Count: " + wt);
            }
        });

        f.setVisible(true);
    }

    private static JButton getjButton() {
        JButton cb = new JButton("Start");
        cb.setAlignmentX(0.5f);
        cb.setFont(new Font("Times New Roman", Font.BOLD, 20));
        cb.setForeground(Color.RED);
        cb.setBackground(new Color(0xD39696));
        int arc = 15;
        cb.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        cb.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cb.setContentAreaFilled(false);
        cb.setFocusPainted(false);

        RoundRectangle2D.Float roundedRectangle = new RoundRectangle2D.Float(0, 0, cb.getWidth() - 1, cb.getHeight() - 1, arc, arc);
        cb.setBorder(BorderFactory.createEmptyBorder());
        cb.setBorder(new CustomRoundedBorder(roundedRectangle, 2));
        return cb;
    }

    private static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        StringTokenizer to = new StringTokenizer(text);
        return to.countTokens();
    }
}

class CustomRoundedBorder extends javax.swing.border.AbstractBorder {
    private final RoundRectangle2D.Float shape;
    private final int thickness;

    public CustomRoundedBorder(RoundRectangle2D.Float shape, int thickness) {
        this.shape = shape;
        this.thickness = thickness;
    }

    @Override
    public void paintBorder(java.awt.Component c, java.awt.Graphics g, int x, int y, int width, int height) {
        java.awt.Graphics2D g2d = (java.awt.Graphics2D) g;
        g2d.setColor(c.getBackground());
        g2d.fill(shape);
        g2d.setColor(c.getForeground());
        g2d.draw(shape);
    }

    @Override
    public java.awt.Insets getBorderInsets(java.awt.Component c) {
        int i = (int) Math.ceil(thickness / 2.0);
        return new java.awt.Insets(i, i, i, i);
    }

}
