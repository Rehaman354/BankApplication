package Bank_App;

import java.util.Scanner;

public class Main {


    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        SBI s1 = null;HDFC h1=null;int bank=0;
      //making the dynamic bank interface for single user
        //we can create many accounts at once by taking no of accounts to be created at the beginning and running loop
        //and storing the objects in datastructure or using dbms
        boolean bool=true;
        while(bool) {
            System.out.println("Enter 1 for creating the SBI account");
            System.out.println("Enter 2 for creating the HDFC account");
            int num = sc.nextInt();
            if (num == 1) {
                bool = false;
                //taking details

                System.out.println("enter the name");
                String name = sc.next();
                System.out.println("enter the amount");
                int balance = sc.nextInt();
                System.out.println("enter the password for account");
                String password = sc.next();
                s1 = new SBI(name, balance, password);
                bank = 1;

            } else if (num == 2) {
                bool = false;
                //taking details

                System.out.println("enter the name");
                String name = sc.next();
                System.out.println("enter the amount");
                int balance = sc.nextInt();
                System.out.println("enter the password for account");
                String password = sc.next();
                h1 = new HDFC(name, balance, password);
                bank = 2;
            } else {
                System.out.println("enter valid input ");
            }
        }
            //actions for user after creating account successfully
            boolean b=true;
            while(b) {
                System.out.println("Enter 1 for addMoney,Enter 2 for withdraw,Enter 3 for checking balance," +
                        "Enter 4 for calculatingrateofInterest,Enter 5 for changing password");
                int n=sc.nextInt();
                switch(n){
                    case 1: System.out.println("Enter the amount to add");
                            double money=sc.nextInt();
                            if(bank==1) System.out.println(s1.addMoney(money));
                            else System.out.println(h1.addMoney(money));
                            break;
                    case 2: System.out.println("Enter the amount to withdraw");
                            double mon=sc.nextInt();
                            System.out.println("Enter the pasword");
                            String pass=sc.next();
                            if(bank==1) System.out.println(s1.withdraw(mon,pass));
                            else System.out.println(h1.withdraw(mon,pass));
                            break;
                    case 3: System.out.println("Enter the pasword");
                            String pas=sc.next();
                            if(bank==1) {
                               double bal= s1.checkBalance(pas);
                               if(bal==-1)System.out.println("Invalid password");
                               else System.out.println(bal);
                            }
                            else {
                                double bal= h1.checkBalance(pas);
                                if(bal==-1)System.out.println("Invalid password");
                                else System.out.println(bal);
                            }
                            break;
                    case 4: System.out.println("Enter the years to find interest on ur balance");
                            int years=sc.nextInt();
                            if(bank==1) System.out.println(s1.calculateRateOfInterest(years));
                            else System.out.println(h1.calculateRateOfInterest(years));
                            break;
                    case 5: System.out.println("Enter the oldpasword");
                            String pas1=sc.next();
                            System.out.println("Enter the newpasword");
                            String pas2=sc.next();
                            if(bank==1) System.out.println(s1.changePassword(pas1,pas2));
                            else System.out.println(h1.changePassword(pas1,pas2));
                }
                System.out.println("if u like to continue,enter 1 ");
                int u=sc.nextInt();
                if(u==1)b=true;
                else b=false;
            }
            System.out.println("Thank u for banking with us,visit again!");

    }
}
