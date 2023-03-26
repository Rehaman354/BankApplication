package com.driver;

public class CurrentAccount extends BankAccount{
   private String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
         if(balance<5000)throw new Exception("Insufficient Balance");
        setName(name);
        setBalance(balance);
        setMinBalance(5000);
        this.tradeLicenseId=tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        String s=this.tradeLicenseId;
        int n=s.length();
        boolean valid=true;
        for(int i=0;i<n-1;i++)
        {
           if(s.charAt(i)==s.charAt(i+1)) valid=false;
        }
        if(valid!=true)
        {
            //we take one freq arr and store frequencies
            int freq[]=new int[26];
            for(int i=0;i<n;i++)
            {
                freq[s.charAt(i)-'A']++;
            }
            //search for the maximum frequency
            int max=Integer.MIN_VALUE;
            int maxchar=-1;
            for(int i=0;i<26;i++)
            {
                if(freq[i]>max) {
                    max = Math.max(max, freq[i]);
                    maxchar=i;
                }
            }
            //if max is greater than
            if(n%2!=0&& (n/2)+1<max)
                throw new Exception("Valid License can not be generated");
            if(n%2==0 && (n/2)<max)
                throw new Exception("Valid License can not be generated");
            //forming the valid by initially filling the odd positions first
            int i=0;
            char[] newId=new char[n];
            while(i<n) {
                if (freq[maxchar] > 0) {
                    newId[i] = (char) (maxchar + 'A');
                    freq[maxchar]--;
                    i = i + 2;
                    if (i >= n) i = 1;
                }
                else {
                    break;
                }
            }
            //now fill remaining positions
            for(int j=0;j<26;j++)
            {
                while(freq[j] > 0) {
                    newId[i] = (char) (j + 'A');
                    freq[j]--;
                    i = i + 2;
                    if (i >= n) i = 1;
                }
            }
            //form the string from char array
            StringBuilder sb=new StringBuilder();
            for(int idx=0;idx<n;idx++)
            {
               sb.append(newId[idx]);
            }
            //strore the licenseId
            this.tradeLicenseId=sb.toString();
        }
    }

}
