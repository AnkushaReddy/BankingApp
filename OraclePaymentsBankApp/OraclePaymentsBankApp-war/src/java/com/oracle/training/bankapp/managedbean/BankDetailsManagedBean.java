/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.training.bankapp.managedbean;


import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author neeshukl
 */
@Named(value = "bankDetailsManagedBean")
@ApplicationScoped
public class BankDetailsManagedBean {

    private String bankName;
    private String bankAddress;
    /**
     * Creates a new instance of BankDetailsManagedBean
     */
    public BankDetailsManagedBean() {
        loadBankDetails();
    }

    public String getBankName() {
        return bankName;
        
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress() {
       return bankAddress;
       
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }
    
    private void loadBankDetails()
    {
        
        bankName = "Oracle Payments Bank";
        bankAddress = "Oracle Campus, Hyderabad";
        
    }
    
    
}
