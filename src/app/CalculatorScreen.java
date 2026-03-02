package app;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
        setSize(Math.max(getWidth(), 520), Math.max(getHeight(), 700));
        setLocationRelativeTo(null);
    }

    private void buildUi() {
        RoundedPanel card = createCard();
        card.setLayout(new BorderLayout(0, OneUiTheme.SPACE_M));

        output.setText("0");
        output.setEditable(false);

        JPanel keypad = new JPanel(new GridLayout(5, 4, OneUiTheme.SPACE_S, OneUiTheme.SPACE_S));
        keypad.setOpaque(false);

        addButton(keypad, "Очистить", false, () -> output.setText(logic.clear()));
        addButton(keypad, "←", false, () -> output.setText(logic.backspace()));
        addButton(keypad, "÷", true, () -> output.setText(logic.setOperator("÷")));
        addButton(keypad, "×", true, () -> output.setText(logic.setOperator("×")));

        addButton(keypad, "7", false, () -> output.setText(logic.appendDigit("7")));
        addButton(keypad, "8", false, () -> output.setText(logic.appendDigit("8")));
        addButton(keypad, "9", false, () -> output.setText(logic.appendDigit("9")));
        addButton(keypad, "−", true, () -> output.setText(logic.setOperator("−")));

        addButton(keypad, "4", false, () -> output.setText(logic.appendDigit("4")));
        addButton(keypad, "5", false, () -> output.setText(logic.appendDigit("5")));
        addButton(keypad, "6", false, () -> output.setText(logic.appendDigit("6")));
        addButton(keypad, "+", true, () -> output.setText(logic.setOperator("+")));

        addButton(keypad, "1", false, () -> output.setText(logic.appendDigit("1")));
        addButton(keypad, "2", false, () -> output.setText(logic.appendDigit("2")));
        addButton(keypad, "3", false, () -> output.setText(logic.appendDigit("3")));
        addButton(keypad, "=", true, this::calculateAndDisplay);

        addButton(keypad, "0", false, () -> output.setText(logic.appendDigit("0")));
        addButton(keypad, ".", false, () -> output.setText(logic.appendDot()));
        JPanel spacer1 = new JPanel();
        spacer1.setOpaque(false);
        JPanel spacer2 = new JPanel();
        spacer2.setOpaque(false);
        keypad.add(spacer1);
        keypad.add(spacer2);

        card.add(output, BorderLayout.NORTH);
        card.add(keypad, BorderLayout.CENTER);
        addCard(card);
    }

    private void addButton(JPanel panel, String text, boolean primary, Runnable action) {
        OneButton button = new OneButton(text, primary);
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
