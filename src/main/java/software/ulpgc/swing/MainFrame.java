package software.ulpgc.swing;

import software.ulpgc.Control.Command;
import software.ulpgc.Control.ExchangeCommand;
import software.ulpgc.CurrencyDialog;
import software.ulpgc.MoneyDialog;
import software.ulpgc.MoneyDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class MainFrame extends JFrame {
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;
    private CurrencyDialog currencyDialog;

    private HashMap<String, Command> Commands = new HashMap<>();
    public MainFrame() throws HeadlessException {
        setTitle("MoneyCalculator");
        setLocationRelativeTo(null);
        setSize(1280,720);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(createMoneyDialog());
        add(createCurrencyDialog());
        add(createMoneyDisplay());
        add(createExchangeButton());
    }

    private Component createExchangeButton() {
        JButton button = new JButton("Exchange");
        button.addActionListener(e -> Commands.get("Exchange").execute());
        return button;
    }

    private Component createCurrencyDialog() {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        this.currencyDialog = dialog;
        return dialog;
    }

    private Component createMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        this.moneyDisplay = display;
        return display;
    }

    private Component createMoneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog();
        this.moneyDialog = dialog;
        return dialog;
    }

    public void add(String name, Command command){ Commands.put(name,command);}

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }

    public CurrencyDialog getCurrencyDialog() {
        return currencyDialog;
    }
}
