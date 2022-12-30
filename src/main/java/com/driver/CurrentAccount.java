package com.driver;
import java.util.Arrays;
public class CurrentAccount extends BankAccount{
       String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId=tradeLicenseId;
        if(balance<5000) {
            throw new Exception("Insufficient Balance");
        }


    }



    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

//        boolean valid = true;
//        for (int i = 0; i < tradeLicenseId.length() - 1; i++) {
//            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i + 1)) {
//                valid = false;
//                break;
//            }
//        }
//        if (!valid) {
//
//            char[] chars = tradeLicenseId.toCharArray();
//
//            Arrays.sort(chars);
//            for (int i = 0; i < chars.length - 1; i++)
//            {
//                if (chars[i] == chars[i + 1])
//                {
//                    throw new Exception("Valid License can not be generated");
//                }
//            }
//        }
//        else {
//            this.tradeLicenseId = tradeLicenseId;
//        }


        if (!isNumberValid(tradeLicenseId)) {
            String newId = newLId(tradeLicenseId);
            if(newId == ""){
                throw new Exception("Valid License can not be generated");
            }
            else{
                this.tradeLicenseId = newId;
            }
        }
    }
    public boolean isNumberValid(String licenseId){
        for(int i = 0; i < licenseId.length()-1; i++){
            if(licenseId.charAt(i) == licenseId.charAt(i+1)){
                return false;
            }
        }
        return true;
    }
    public String newLId(String S)
    {
        int N = S.length();

        int[] count = new int[26];
        for (int i = 0; i < 26; i++) {
            count[i] = 0;
        }
        for (char ch : S.toCharArray()) {
            count[(int)ch - (int)'A']++;
        }

        int max = 0;
        char ch_max = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                ch_max = (char)((int)'A' + i);
            }
        }

        int maxCount = count[(int)ch_max - (int)'A'];

        if (maxCount > (N + 1) / 2)
            return "";

        String res = "";
        for (int i = 0; i < N; i++) {
            res += ' ';
        }

        int ind = 0;
        while (maxCount > 0) {
            res = res.substring(0, ind) + ch_max
                    + res.substring(ind + 1);
            ind = ind + 2;
            maxCount--;
        }
        count[(int)ch_max - (int)'A'] = 0;
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                ind = (ind >= N) ? 1 : ind;
                res = res.substring(0, ind)
                        + (char)((int)'A' + i)
                        + res.substring(ind + 1);
                ind += 2;
                count[i]--;
            }
        }
        return res;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

}
