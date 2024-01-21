package software.ulpgc.Mock;

import software.ulpgc.CurrencyDialog;
import software.ulpgc.Model.Currency;
import java.util.List;
import java.util.Scanner;

public class MockCurrencyDialog implements CurrencyDialog {
    private List<Currency> currencies;
    @Override
    public CurrencyDialog define(List<Currency> currencies) {
        this.currencies = currencies;
        return this;
    }

    @Override
    public Currency get() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introdusca una divisa:");
            String divisa = scanner.next();
            if (findCurrencies(divisa)) return new Currency(divisa);
            System.out.println("La divisa no ha sido reconocida");
        }
    }
    boolean findCurrencies(String Code){
        return currencies.stream().anyMatch((a) -> Code.equals(a.code()));
    }
}
