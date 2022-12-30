package com.driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CurrentAccount extends BankAccount {
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
        if (balance < 5000) {
            throw new Exception("Insufficient Balance");
        }


    }


    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        boolean valid = true;
        for (int i = 0; i < tradeLicenseId.length() - 1; i++) {
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i + 1)) {
                valid = false;
                break;
            }
        }
        if (!valid) {

            char[] chars = tradeLicenseId.toCharArray();

            Arrays.sort(chars);
            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] == chars[i + 1]) {
                    throw new Exception("Valid License can not be generated");
                }
            }
        } else {
            this.tradeLicenseId = tradeLicenseId;
        }

    }
    public String getTradeLicenseId() {
        return tradeLicenseId;
    }
}