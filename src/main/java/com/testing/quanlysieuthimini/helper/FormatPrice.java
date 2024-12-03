package com.testing.quanlysieuthimini.helper;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author admin
 */
public class FormatPrice {

    public static String formatCurrency(double amount) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        return currencyFormatter.format(amount);
    }

    // Hàm chuyển đổi chuỗi tiền tệ Việt Nam về dạng double
    public static double parseCurrency(String currencyStr) throws ParseException {
        // Tạo đối tượng NumberFormat cho định dạng tiền tệ Việt Nam
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

        // Loại bỏ khoảng trắng và ký hiệu tiền tệ (nếu có)
        currencyStr = currencyStr.replace("₫", "").trim();

        // Parse chuỗi thành Number và sau đó chuyển thành double
        Number number = currencyFormatter.parse(currencyStr);
        return number.doubleValue();
    }
}
