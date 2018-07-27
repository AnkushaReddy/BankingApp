/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.training.bankapp.managedbean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author akamredd
 */
@Named(value = "fundTransferManagedBean")
@SessionScoped
public class FundTransferManagedBean implements Serializable {

    /**
     * Creates a new instance of FundTransferManagedBean
     */
    public FundTransferManagedBean() {
        
    }
    private String name;
    private String AccountNo;
    private double balance;

    public String getName() {
        return name;
    }

    public String getAccountNo() {
        return AccountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNo(String AccountNo) {
        this.AccountNo = AccountNo;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void doCredit(){
        balance+=balance;
        
    }
    public void doDebit(){
        balance-=balance;
    }
    public String action(){
        return "fail";
    }
    
    
}
