package software.ulpgc;

import software.ulpgc.Api.ApiRateLoader;
import software.ulpgc.Control.ExchangeCommand;
import software.ulpgc.Mock.MockCurrencyLoader;
import software.ulpgc.Mock.MockExchangeRateLoader;
import software.ulpgc.Model.Currency;
import software.ulpgc.swing.MainFrame;

import java.util.List;

public class MainSwing {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        MockCurrencyLoader mockCurrencyLoader = new MockCurrencyLoader();
        List<Currency> currenciesList = mockCurrencyLoader.load();
        CurrencyDialog currencyDialog = frame.getCurrencyDialog().define(currenciesList);
        MoneyDisplay moneyDisplay = frame.getMoneyDisplay();
        MoneyDialog moneyDialog = frame.getMoneyDialog().define(currenciesList);
        MockExchangeRateLoader mockExchangeRateLoader = new MockExchangeRateLoader(new ApiRateLoader());
        frame.add("Exchange",new ExchangeCommand(currencyDialog,moneyDisplay,mockExchangeRateLoader,moneyDialog));
        frame.setVisible(true);
    }
}
