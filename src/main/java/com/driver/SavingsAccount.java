package com.driver;

public class SavingsAccount extends BankAccount{
    private double rate;
    private double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.maxWithdrawalLimit=maxWithdrawalLimit;
        this.rate=rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
         if(amount>this.maxWithdrawalLimit)
             throw new Exception("Maximum Withdraw Limit Exceed");
         else if(amount>getBalance())
             throw new Exception("Insufficient Balance");
         else {
             double b=getBalance();
             setBalance(b-amount);
         }
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        return (getBalance()*rate*years)/100;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        //compound interest formula is CI=P(1+(r/n))^(nt)-> where n is the no of times in a year interest is generated
        //i.e., if n==12 it means monthly calculated
        //if n==3 it means every 4 months ,interest is added to main  balance
        return getBalance()*Math.pow((1+(rate/times)),(times*years));
    }

}
