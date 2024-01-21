package software.ulpgc;

import software.ulpgc.Api.ApiRateLoader;
import software.ulpgc.Control.ExchangeCommand;
import software.ulpgc.Mock.*;

import software.ulpgc.Model.Currency;


import java.util.List;

public class Main {

    public static void main(String[] args) {
        CurrencyLoader mockCurrencyLoader = new MockCurrencyLoader();
        List<Currency> currencies = mockCurrencyLoader.load();
        CurrencyDialog currencyDialog = new MockCurrencyDialog().define(currencies);
        MoneyDialog moneyDialog = new MockMoneyDialog().define(currencies);
        MoneyDisplay moneyDisplay = new MockMoneyDisplay();
        ExchangeRateLoader exchangeRateLoader = new MockExchangeRateLoader(new ApiRateLoader());
        ExchangeCommand exchangeCommand = new ExchangeCommand(currencyDialog, moneyDisplay,exchangeRateLoader, moneyDialog);
        exchangeCommand.execute();

    }
}
