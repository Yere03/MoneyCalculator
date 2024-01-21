package software.ulpgc.swing;

import software.ulpgc.CurrencyDialog;
import software.ulpgc.Model.Currency;
import software.ulpgc.Model.Money;
import software.ulpgc.MoneyDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {
    private JTextField moneyAmount;
    private CurrencyDialog currecyDialog;

    public SwingMoneyDialog() {
        setLayout(new FlowLayout());
        add(moneyAmount = createField());
    }

    @Override
    public MoneyDialog define(List<Currency> currencies) {
        CurrencyDialog dialog = new SwingCurrencyDialog().define(currencies);
        add((Component) (this.currecyDialog = dialog));
        return this;
    }

    private JTextField createField() {
        JTextField result = new JTextField();
        result.setColumns(6);
        return result;
    }

    @Override
    public Money get() {
        return new Money(Double.parseDouble(moneyAmount.getText()), currecyDialog.get());
    }
}
