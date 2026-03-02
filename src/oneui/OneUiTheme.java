package oneui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public final class OneUiTheme {
    private OneUiTheme() {
    }

    public static final Color BG_APP = new Color(244, 246, 250);
    public static final Color BG_CARD = Color.WHITE;
    public static final Color BORDER = new Color(220, 226, 236);

    public static final Color TEXT_PRIMARY = new Color(23, 27, 35);
    public static final Color TEXT_SECONDARY = new Color(94, 104, 121);

    public static final Color NUMBER_TEXT = new Color(36, 110, 235);
    public static final Color NUMBER_BG = new Color(240, 246, 255);
    public static final Color NUMBER_BG_HOVER = new Color(226, 238, 255);
    public static final Color NUMBER_BG_PRESS = new Color(209, 227, 255);

    public static final Color OPERATOR_TEXT = new Color(26, 151, 91);
    public static final Color OPERATOR_BG = new Color(234, 248, 239);
    public static final Color OPERATOR_BG_HOVER = new Color(220, 242, 228);
    public static final Color OPERATOR_BG_PRESS = new Color(204, 234, 216);

    public static final Color CLEAR_TEXT = new Color(198, 52, 52);
    public static final Color CLEAR_BG = new Color(254, 237, 237);
    public static final Color CLEAR_BG_HOVER = new Color(250, 224, 224);
    public static final Color CLEAR_BG_PRESS = new Color(245, 209, 209);

    public static final Color NEUTRAL_TEXT = new Color(70, 81, 98);
    public static final Color NEUTRAL_BG = new Color(239, 242, 248);
    public static final Color NEUTRAL_BG_HOVER = new Color(228, 233, 242);
    public static final Color NEUTRAL_BG_PRESS = new Color(214, 220, 231);

    public static final Font FONT_TITLE = new Font("SansSerif", Font.BOLD, 34);
    public static final Font FONT_BUTTON = new Font("SansSerif", Font.BOLD, 22);
    public static final Font FONT_OUTPUT = new Font("SansSerif", Font.BOLD, 54);

    public static final int RADIUS_L = 24;
    public static final int RADIUS_M = 20;

    public static final int SPACE_S = 14;
    public static final int SPACE_M = 20;
    public static final int SPACE_L = 28;
    public static final int BUTTON_DIAMETER = 84;
    public static final int BUTTON_SPACING = 18;

    public static Border cardPadding() {
        return BorderFactory.createEmptyBorder(SPACE_M, SPACE_M, SPACE_M, SPACE_M);
    }
}
