package software.ulpgc;

import software.ulpgc.Model.Money;

import software.ulpgc.Model.Currency;
import java.util.List;

public interface MoneyDialog {
    MoneyDialog define(List<Currency> currencies);

    Money get();
}
