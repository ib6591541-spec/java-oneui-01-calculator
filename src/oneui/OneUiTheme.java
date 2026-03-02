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
    public static final Color PRIMARY = new Color(31, 111, 235);
    public static final Color PRIMARY_PRESSED = new Color(25, 91, 194);
    public static final Color SECONDARY = new Color(232, 236, 243);
    public static final Color SECONDARY_PRESSED = new Color(214, 220, 231);
    public static final Color TEXT_PRIMARY = new Color(23, 27, 35);
    public static final Color TEXT_SECONDARY = new Color(94, 104, 121);
    public static final Color ERROR = new Color(191, 54, 55);
    public static final Color BORDER = new Color(220, 226, 236);

    public static final Font FONT_TITLE = new Font("SansSerif", Font.BOLD, 34);
    public static final Font FONT_HEADLINE = new Font("SansSerif", Font.BOLD, 22);
    public static final Font FONT_BODY = new Font("SansSerif", Font.PLAIN, 16);
    public static final Font FONT_BUTTON = new Font("SansSerif", Font.BOLD, 18);
    public static final Font FONT_OUTPUT = new Font("SansSerif", Font.BOLD, 28);

    public static final int RADIUS_L = 24;
    public static final int RADIUS_M = 20;
    public static final int RADIUS_S = 16;

    public static final int SPACE_XXS = 6;
    public static final int SPACE_XS = 10;
    public static final int SPACE_S = 14;
    public static final int SPACE_M = 20;
    public static final int SPACE_L = 28;

    public static Border cardPadding() {
        return BorderFactory.createEmptyBorder(SPACE_M, SPACE_M, SPACE_M, SPACE_M);
    }
}
