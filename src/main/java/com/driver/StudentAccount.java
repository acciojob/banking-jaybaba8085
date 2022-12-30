package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;
    double balance;
    String getInstitutionName;

    public StudentAccount(String name, double balance, String  institutionName) {
        //minimum balance is 0 by default
      super(name,balance,0);
      this.institutionName=institutionName;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getGetInstitutionName() {
        return getInstitutionName;
    }

    public void setGetInstitutionName(String getInstitutionName) {
        this.getInstitutionName = getInstitutionName;
    }
}
