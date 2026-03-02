package app;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import oneui.OneUiComponents.CircleButton;
import javax.swing.JPanel;
import oneui.OneUiComponents.OneButton;
import oneui.OneUiComponents.OneTextField;
import oneui.OneUiComponents.RoundedPanel;
import oneui.OneUiDialogs;
import oneui.OneUiFrame;
import oneui.OneUiTheme;

public class CalculatorScreen extends OneUiFrame {
    private final CalculatorLogic logic = new CalculatorLogic();
    private final OneTextField output = new OneTextField();

    public CalculatorScreen() {
        super("Калькулятор");
        buildUi();
        pack();
        setSize(Math.max(getWidth(), 520), Math.max(getHeight(), 760));
        setSize(Math.max(getWidth(), 520), Math.max(getHeight(), 700));
        setLocationRelativeTo(null);
    }

    private void buildUi() {
        RoundedPanel card = createCard();
        card.setLayout(new BorderLayout(0, OneUiTheme.SPACE_M));
        card.setBorder(BorderFactory.createEmptyBorder(22, 22, 24, 22));

        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setOpaque(false);
        displayPanel.setBorder(BorderFactory.createEmptyBorder(12, 4, 10, 4));

        output.setText("0");
        output.setEditable(false);

        JPanel displayContent = new JPanel(new BorderLayout());
        displayContent.setOpaque(false);
        displayContent.add(Box.createVerticalStrut(120), BorderLayout.NORTH);
        displayContent.add(output, BorderLayout.CENTER);
        displayContent.add(Box.createVerticalStrut(26), BorderLayout.SOUTH);

        JSeparator divider = new JSeparator();
        divider.setForeground(OneUiTheme.BORDER);

        displayPanel.add(displayContent, BorderLayout.CENTER);
        displayPanel.add(divider, BorderLayout.SOUTH);

        JPanel keypad = new JPanel(new GridLayout(5, 4, OneUiTheme.BUTTON_SPACING, OneUiTheme.BUTTON_SPACING));
        keypad.setOpaque(false);
        keypad.setBorder(BorderFactory.createEmptyBorder(18, 2, 2, 2));

        addClearButton(keypad, "C", () -> output.setText(logic.clear()));
        addNeutralButton(keypad, "←", () -> output.setText(logic.backspace()));
        addOperatorButton(keypad, "÷", () -> output.setText(logic.setOperator("÷")));
        addOperatorButton(keypad, "×", () -> output.setText(logic.setOperator("×")));

        addNumberButton(keypad, "7");
        addNumberButton(keypad, "8");
        addNumberButton(keypad, "9");
        addOperatorButton(keypad, "−", () -> output.setText(logic.setOperator("−")));

        addNumberButton(keypad, "4");
        addNumberButton(keypad, "5");
        addNumberButton(keypad, "6");
        addOperatorButton(keypad, "+", () -> output.setText(logic.setOperator("+")));

        addNumberButton(keypad, "1");
        addNumberButton(keypad, "2");
        addNumberButton(keypad, "3");
        addOperatorButton(keypad, "=", this::calculateAndDisplay);

        addNumberButton(keypad, "0");
        addNeutralButton(keypad, ".", () -> output.setText(logic.appendDot()));
        keypad.add(createSpacer());
        keypad.add(createSpacer());

        card.add(displayPanel, BorderLayout.NORTH);
        card.add(keypad, BorderLayout.CENTER);
        addCard(card);
    }

    private JPanel createSpacer() {
        JPanel spacer = new JPanel();
        spacer.setOpaque(false);
        return spacer;
    }

    private void addNumberButton(JPanel panel, String digit) {
        addButton(panel, digit, OneUiTheme.NUMBER_TEXT, OneUiTheme.NUMBER_BG, OneUiTheme.NUMBER_BG_HOVER,
                OneUiTheme.NUMBER_BG_PRESS, () -> output.setText(logic.appendDigit(digit)));
    }

    private void addOperatorButton(JPanel panel, String text, Runnable action) {
        addButton(panel, text, OneUiTheme.OPERATOR_TEXT, OneUiTheme.OPERATOR_BG, OneUiTheme.OPERATOR_BG_HOVER,
                OneUiTheme.OPERATOR_BG_PRESS, action);
    }

    private void addClearButton(JPanel panel, String text, Runnable action) {
        addButton(panel, text, OneUiTheme.CLEAR_TEXT, OneUiTheme.CLEAR_BG, OneUiTheme.CLEAR_BG_HOVER,
                OneUiTheme.CLEAR_BG_PRESS, action);
    }

    private void addNeutralButton(JPanel panel, String text, Runnable action) {
        addButton(panel, text, OneUiTheme.NEUTRAL_TEXT, OneUiTheme.NEUTRAL_BG, OneUiTheme.NEUTRAL_BG_HOVER,
                OneUiTheme.NEUTRAL_BG_PRESS, action);
    }

    private void addButton(JPanel panel, String text, java.awt.Color textColor, java.awt.Color bg, java.awt.Color hover,
                           java.awt.Color press, Runnable action) {
        CircleButton button = new CircleButton(text, textColor, bg, hover, press);
        button.addActionListener(e -> action.run());
        panel.add(button);
    }

    private void calculateAndDisplay() {
        String result = logic.calculate();
        output.setText(result);
        if (logic.hasError()) {
            OneUiDialogs.showError(this, logic.getErrorMessage());
        }
    }
}
