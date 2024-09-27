package utils;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {
    public static String convertToRupiah(double amount) {
        // Locale untuk Indonesia
        Locale indonesia = new Locale("id", "ID");
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(indonesia);

        // Menghilangkan simbol Rp yang berlebihan
        return rupiahFormat.format(amount).replace("Rp", "Rp ");
    }
}
