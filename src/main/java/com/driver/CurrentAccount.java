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
            String str = new String("");
            str = generateId(s, 0, n - 1);
            if (str.length() == 0)
                throw new Exception("Valid License can not be generated");
            else
                this.tradeLicenseId = str;
        }
    }
    public String generateId(String s,int l,int r)
    {
        String ans="";
        String stri=permute(s,ans);
        return stri;
    }
    public String permute(String s,String asf)
    {
        if(s.length()==0)
        {
            boolean b=isValid(asf);
            if(b==true)
                return asf;
            return "";
        }
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            String st=permute(s.substring(i+1),asf+s.charAt(i));
            if(st.length()!=0)return st;
        }
        return null;
    }
    public boolean isValid(String s){

        int n=s.length();
        for(int i=0;i<n-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1)) return false;
        }
        return true;
    }

}
