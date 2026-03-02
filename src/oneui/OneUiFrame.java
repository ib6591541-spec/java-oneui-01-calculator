package oneui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import oneui.OneUiComponents.RoundedPanel;

public class OneUiFrame extends JFrame {
    private final JPanel contentPanel;

    public OneUiFrame(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(520, 700));
        setMinimumSize(new Dimension(480, 640));
        getContentPane().setBackground(OneUiTheme.BG_APP);
        setLayout(new BorderLayout());

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, OneUiTheme.SPACE_L, OneUiTheme.SPACE_L));
        top.setOpaque(false);
        JLabel header = new JLabel(title, SwingConstants.LEFT);
        header.setFont(OneUiTheme.FONT_TITLE);
        header.setForeground(OneUiTheme.TEXT_PRIMARY);
        top.add(header);

        contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new javax.swing.BoxLayout(contentPanel, javax.swing.BoxLayout.Y_AXIS));
        contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, OneUiTheme.SPACE_L, OneUiTheme.SPACE_L, OneUiTheme.SPACE_L));

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.getVerticalScrollBar().setUnitIncrement(12);

        add(top, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public RoundedPanel createCard() {
        RoundedPanel card = new RoundedPanel(OneUiTheme.RADIUS_L);
        card.setAlignmentX(LEFT_ALIGNMENT);
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        return card;
    }

    public void addCard(JPanel card) {
        contentPanel.add(card);
        contentPanel.add(javax.swing.Box.createVerticalStrut(OneUiTheme.SPACE_M));
    }
}
