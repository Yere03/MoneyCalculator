package software.ulpgc;

import software.ulpgc.Model.Currency;
import java.util.List;

public interface CurrencyDialog {
    CurrencyDialog define(List<Currency> currencies);

    Currency get();

}
