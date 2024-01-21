package software.ulpgc.swing;

import software.ulpgc.CurrencyDialog;
import software.ulpgc.Model.Currency;

import javax.swing.*;
import java.util.List;


public class SwingCurrencyDialog extends JPanel implements CurrencyDialog {
    private List<Currency> currencies;
    private JList<Currency> currencyJComboBox;
    @Override
    public CurrencyDialog define(List<Currency> currencies) {
        this.currencies = currencies;
        add(currencyJComboBox = createCurrencySelector(currencies));
        return this;
    }

    private JList<Currency> createCurrencySelector(List<Currency> currencies) {
        DefaultListModel<Currency> l1 = new DefaultListModel<>();
        for (Currency currency: currencies) {
            l1.addElement(currency);
        }
        JList<Currency> currencyJList = new JList(l1);
        return currencyJList;
    }

    @Override
    public Currency get() {return currencyJComboBox.getSelectedValue();}
}
