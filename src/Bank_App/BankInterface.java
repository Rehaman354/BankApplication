package Bank_App;

public interface BankInterface {
    //actioins(Interface methods)

    //add money
    public String addMoney(double money);

    //withdraw money
    public String withdraw(double money,String password);

    //check balance
    public double checkBalance(String password);

    //update password
    public String changePassword(String oldPassword,String newPassword);

    //calculate roi
    public double calculateRateOfInterest(int years);

    //transfer money with in same bank account
    // public String Transfer(double money,String password, bankobject toName);

}
