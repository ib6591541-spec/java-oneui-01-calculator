package oneui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class OneUiComponents {
    private OneUiComponents() {
    }

    public static class RoundedPanel extends JPanel {
        private final int radius;

        public RoundedPanel(int radius) {
            this.radius = radius;
            setOpaque(false);
            setBorder(OneUiTheme.cardPadding());
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(OneUiTheme.BG_CARD);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
            g2.setColor(OneUiTheme.BORDER);
            g2.setStroke(new BasicStroke(1f));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    public static class OneButton extends JButton {
        private boolean pressed;

        public OneButton(String text, boolean primary) {
            super(text);
            setFont(OneUiTheme.FONT_BUTTON);
            setForeground(primary ? Color.WHITE : OneUiTheme.TEXT_PRIMARY);
            setFocusPainted(false);
            setContentAreaFilled(false);
            setBorderPainted(false);
            setOpaque(false);
            setMargin(new Insets(12, 12, 12, 12));
            setPreferredSize(new Dimension(92, 62));
            setBackground(primary ? OneUiTheme.PRIMARY : OneUiTheme.SECONDARY);
            putClientProperty("primary", primary);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    pressed = true;
                    repaint();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    pressed = false;
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            boolean primary = (boolean) getClientProperty("primary");
            Color color;
            if (pressed) {
                color = primary ? OneUiTheme.PRIMARY_PRESSED : OneUiTheme.SECONDARY_PRESSED;
            } else {
                color = getBackground();
            }

            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), OneUiTheme.RADIUS_S, OneUiTheme.RADIUS_S);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    public static class OneTextField extends JTextField {
        public OneTextField() {
            setFont(OneUiTheme.FONT_OUTPUT);
            setForeground(OneUiTheme.TEXT_PRIMARY);
            setBackground(OneUiTheme.SECONDARY);
            setCaretColor(OneUiTheme.PRIMARY);
            setBorder(BorderFactory.createEmptyBorder(16, 18, 16, 18));
            setOpaque(false);
            setHorizontalAlignment(RIGHT);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), OneUiTheme.RADIUS_M, OneUiTheme.RADIUS_M);
            g2.dispose();
            super.paintComponent(g);
        }
    }
}
