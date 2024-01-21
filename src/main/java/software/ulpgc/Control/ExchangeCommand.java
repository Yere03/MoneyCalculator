package software.ulpgc.Control;

import software.ulpgc.CurrencyDialog;
import software.ulpgc.ExchangeRateLoader;
import software.ulpgc.Model.Currency;
import software.ulpgc.Model.ExchangeRate;
import software.ulpgc.Model.Money;
import software.ulpgc.MoneyDialog;
import software.ulpgc.MoneyDisplay;

public class ExchangeCommand implements Command{
    private final ExchangeRateLoader exchangeRateLoader;
    private final CurrencyDialog currencyDialog;
    private final MoneyDisplay moneyDisplay;
    private final MoneyDialog moneyDialog;
    
    public ExchangeCommand(CurrencyDialog currencyDialog, MoneyDisplay moneyDisplay, ExchangeRateLoader exchangeRateLoader, MoneyDialog moneyDialog) {
        this.currencyDialog = currencyDialog;
        this.moneyDisplay = moneyDisplay;
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDialog = moneyDialog;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.get();
        Currency target = currencyDialog.get();
        ExchangeRate exchangeRate = exchangeRateLoader.load(money.currency(), target);
        moneyDisplay.show(new Money(money.amount()*exchangeRate.rate(),target));
    }
}
