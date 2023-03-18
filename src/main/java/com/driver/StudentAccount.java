package com.driver;

public class StudentAccount extends BankAccount{

    private String  institutionName;

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public StudentAccount(String name, double balance, String  institutionName) {
        //minimum balance is 0 by default
        super(name,balance,0);
        this.institutionName=institutionName;
    }

}
