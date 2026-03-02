package oneui;

import javax.swing.JOptionPane;

public final class OneUiDialogs {
    private OneUiDialogs() {
    }

    public static void showInfo(java.awt.Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Информация", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showError(java.awt.Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }

    public static boolean showConfirm(java.awt.Component parent, String message) {
        int answer = JOptionPane.showConfirmDialog(parent, message, "Подтверждение", JOptionPane.YES_NO_OPTION);
        return answer == JOptionPane.YES_OPTION;
    }
}
