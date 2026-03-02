package oneui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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

    public static class CircleButton extends JButton {
        private final Color normal;
        private final Color hover;
        private final Color press;
        private boolean isHover;
        private boolean isPress;

        public CircleButton(String text, Color textColor, Color normal, Color hover, Color press) {
            super(text);
            this.normal = normal;
            this.hover = hover;
            this.press = press;

            setFont(OneUiTheme.FONT_BUTTON);
            setForeground(textColor);
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
            setBorder(BorderFactory.createEmptyBorder());
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
            setPreferredSize(new Dimension(OneUiTheme.BUTTON_DIAMETER, OneUiTheme.BUTTON_DIAMETER));
            setMinimumSize(new Dimension(OneUiTheme.BUTTON_DIAMETER, OneUiTheme.BUTTON_DIAMETER));

            addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    isHover = true;
                    repaint();
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    isHover = false;
                    isPress = false;
                    repaint();
                }

                @Override
                public void mousePressed(java.awt.event.MouseEvent e) {
                    isPress = true;
                    repaint();
                }

                @Override
                public void mouseReleased(java.awt.event.MouseEvent e) {
                    isPress = false;
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Color bg = normal;
            if (isPress) {
                bg = press;
            } else if (isHover) {
                bg = hover;
            }

            int diameter = Math.min(getWidth(), getHeight()) - 2;
            int x = (getWidth() - diameter) / 2;
            int y = (getHeight() - diameter) / 2;

            g2.setColor(bg);
            g2.fillOval(x, y, diameter, diameter);
            g2.dispose();
            super.paintComponent(g);
        }
    }

    public static class OneTextField extends JTextField {
        public OneTextField() {
            setFont(OneUiTheme.FONT_OUTPUT);
            setForeground(OneUiTheme.TEXT_PRIMARY);
            setBackground(OneUiTheme.BG_CARD);
            setCaretColor(OneUiTheme.TEXT_PRIMARY);
            setBorder(BorderFactory.createEmptyBorder(10, 8, 10, 8));
            setOpaque(false);
            setHorizontalAlignment(RIGHT);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
    }
}
