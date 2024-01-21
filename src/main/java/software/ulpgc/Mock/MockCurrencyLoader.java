package software.ulpgc.Mock;

import software.ulpgc.CurrencyLoader;
import software.ulpgc.Model.Currency;

import java.util.List;

public class MockCurrencyLoader implements CurrencyLoader {
    @Override
    public List<Currency> load() {
        return List.of(
                new Currency("USD"),
                new Currency("EUR"),
                new Currency("GBP"));
    }
}

