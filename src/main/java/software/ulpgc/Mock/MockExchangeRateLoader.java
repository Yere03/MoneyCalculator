package software.ulpgc.Mock;

import software.ulpgc.Api.ApiRateLoader;
import software.ulpgc.ExchangeRateLoader;
import software.ulpgc.Model.Currency;
import software.ulpgc.Model.ExchangeRate;

public class MockExchangeRateLoader implements ExchangeRateLoader {
    private final ApiRateLoader apiRateLoader;

    public MockExchangeRateLoader(ApiRateLoader apiRateGetter) {
        this.apiRateLoader = apiRateGetter;
    }

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        double rate = apiRateLoader.load(from.code(), to.code());
        return new ExchangeRate(from,to,rate);
    }
}
