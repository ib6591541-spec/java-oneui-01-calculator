package app;

import java.text.DecimalFormat;

public class CalculatorLogic {
    private String currentInput = "0";
    private Double firstOperand;
    private String operator;
    private boolean resetInput;
    private String errorMessage;
    private final DecimalFormat formatter = new DecimalFormat("0.########");

    public String appendDigit(String digit) {
        if (hasError()) {
            clear();
        }

        if (resetInput) {
            currentInput = "0";
            resetInput = false;
        }

        if ("0".equals(currentInput)) {
            currentInput = digit;
        } else {
            currentInput += digit;
        }
        return currentInput;
    }

    public String appendDot() {
        if (hasError()) {
            clear();
        }

        if (resetInput) {
            currentInput = "0";
            resetInput = false;
        }

        if (!currentInput.contains(".")) {
            currentInput += ".";
        }
        return currentInput;
    }

    public String setOperator(String op) {
        if (hasError()) {
            clear();
        }

        firstOperand = Double.parseDouble(currentInput);
        operator = op;
        resetInput = true;
        return currentInput;
    }

    public String backspace() {
        if (hasError()) {
            clear();
            return currentInput;
        }

        if (resetInput) {
            return currentInput;
        }

        if (currentInput.length() > 1) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
        } else {
            currentInput = "0";
        }

        if ("-".equals(currentInput)) {
            currentInput = "0";
        }
        return currentInput;
    }

    public String calculate() {
        if (hasError()) {
            return errorMessage;
        }
        if (firstOperand == null || operator == null || resetInput) {
            return currentInput;
        }

        double secondOperand = Double.parseDouble(currentInput);
        double result;

        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "−":
                result = firstOperand - secondOperand;
                break;
            case "×":
                result = firstOperand * secondOperand;
                break;
            case "÷":
                if (secondOperand == 0) {
                    errorMessage = "Ошибка: деление на ноль";
                    return errorMessage;
                }
                result = firstOperand / secondOperand;
                break;
            default:
                return currentInput;
        }

        currentInput = formatter.format(result);
        firstOperand = null;
        operator = null;
        resetInput = true;
        return currentInput;
    }

    public String clear() {
        currentInput = "0";
        firstOperand = null;
        operator = null;
        resetInput = false;
        errorMessage = null;
        return currentInput;
    }

    public boolean hasError() {
        return errorMessage != null;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
