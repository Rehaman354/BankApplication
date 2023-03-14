package Bank_App;

import java.util.UUID;

public class HDFC implements BankInterface{
    private String accountNo;
    public String name;
    private double balance;
    private String password;

    public static double rateOfInterest= 6;

   //constructor of HDFC
    public HDFC(String name, double openingBalance, String password) {
        this.accountNo= UUID.randomUUID().toString();
        this.name= name;
        this.balance=openingBalance;
        this.password=password;
        System.out.println("HDFC account created successfully");
    }

    @Override
    public String addMoney(double money) {
        balance=balance+money;
        return "Money added Successfully into ur hdfc account";
    }

    @Override
    public String withdraw(double money, String password) {
        if(this.password.equals(password))
        {
            if(balance>=money)
            {
                balance=balance-money;
                return "withdrawal is successful. The balance is : "+balance;
            }
            else {
                return "Insufficient balance";
            }
        }
        return "Invalid Password";
    }

//transfer action
//    public String Transfer(double money, String password, HDFC h1) {
//        if(this.password.equals(password))
//        {
//            if(balance>=money)
//            {
//                balance=balance-money;
//                h1.balance+=money;
//                return "Transfer is successful. The Remaining balance is : "+balance;
//            }
//            else {
//                return "Insufficient balance";
//            }
//        }
//        return "Invalid password.Transaction failed";
//    }

    @Override
    public double checkBalance(String password) {
        if(this.password.equals(password))
        {
            return balance;
        }
        return -1;
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if(this.password.equals(oldPassword))
        {
            this.password=newPassword;
            return "Password Updated Suucessfully";
        }
        return "please enter old password correctly!";
    }
    @Override
    public double calculateRateOfInterest(int years) {
        return (this.balance*rateOfInterest*years)/100;
    }
}
