package software.ulpgc.Mock;

import software.ulpgc.CurrencyDialog;
import software.ulpgc.Model.Money;
import software.ulpgc.MoneyDialog;

import software.ulpgc.Model.Currency;
import java.util.List;
import java.util.Scanner;

public class MockMoneyDialog implements MoneyDialog {
    private CurrencyDialog currencyDialog;
    @Override
    public MoneyDialog define(List<Currency> currencies) {
        currencyDialog = new MockCurrencyDialog().define(currencies);
        return this;
    }

    @Override
    public Money get() {return new Money(amount(), currencyDialog.get());}

    private double amount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdusca una cantidad:");
        return scanner.nextDouble();
    }
}
