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
//    public String rearrangeLicenseId() throws Exception {
//        List<String> permutations = new ArrayList<>();
//        permute(tradeLicenseId.toCharArray(), 0, permutations);
//
//        // Check each permutation to see if it is a valid license ID
//        for (String permutation : permutations) {
//            try {
//                validateLicenseId(permutation);
//                // If a valid permutation is found, return it
//                return permutation;
//            } catch (Exception e) {
//                // Do nothing, just continue to the next permut
//    }
//
//
//
//    public String getTradeLicenseId() {
//        return tradeLicenseId;
//    }
//
//}
//        boolean valid = true;
//        for (int i = 0; i < tradeLicenseId.length() - 1; i++) {
//            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i + 1)) {
//                valid = false;
//                break;
//            }
//        }
//        if (!valid)
//        {
//            String s=rearrangeLicenseId();
//
//            if(s!="Valid License can not be generated")
//            {
//                this.tradeLicenseId = s;
//            }
//            else throw new Exception("Valid License can not be generated");
//        }
//    }
//    public boolean validateLicenseIds(String permutation) throws Exception {
//        // Check if the trade license ID is valid
//        for (int i = 0; i < permutation.length() - 1; i++) {
//            if (permutation.charAt(i) ==permutation.charAt(i+1)) {
//                return false;    }
//        }
//        return true;
//    }
//    public String rearrangeLicenseId() throws Exception {
//
//        List<String> permutations = new ArrayList<>();
//        permute(tradeLicenseId.toCharArray(), 0, permutations);
//        boolean b= false;
//        // Check each permutation to see if it is a valid license ID
//        for (String permutation : permutations) {
//
//            b = validateLicenseIds(permutation);
//            // If a valid permutation is found, return it
//            if(b==true)
//                return permutation;
//            else continue;
//        }
//        return "Valid License can not be generated";
//
//    }
//    private void permute(char[] arr, int index, List<String> permutations)
//    {
//        if (index >= arr.length)
//        {
//            permutations.add(new String(arr));
//            return;
//        }
//
//        for (int i = index; i < arr.length; i++)
//        {
//            swap(arr, index, i);
//            permute(arr, index + 1, permutations);
//            swap(arr, index, i);
//        }
//    }
//    private void swap(char[] arr, int i, int j)
//    {
//        char temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
   // }