package software.ulpgc.swing;

import software.ulpgc.Model.Money;
import software.ulpgc.MoneyDisplay;

import javax.swing.*;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay {
    private final JLabel moneyAmountConverted;

    public SwingMoneyDisplay() {
        add (moneyAmountConverted = new JLabel());
    }

    @Override
    public void show(Money money) {moneyAmountConverted.setText(money.toString());}
}
