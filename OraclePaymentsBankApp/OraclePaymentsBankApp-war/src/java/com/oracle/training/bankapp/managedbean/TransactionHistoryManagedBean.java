/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.training.bankapp.managedbean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author neeshukl
 */
@Named(value = "transactionHistoryManagedBean")
@SessionScoped
public class TransactionHistoryManagedBean implements Serializable {

    private List<TransactionHist> txnHistory; 
    private int accountNumber;
    /**
     * Creates a new instance of TransactionHistoryManagedBean
     */
    
    public TransactionHistoryManagedBean() {
    }
    
    

    public List<TransactionHist> getTxnHistory() {
        return txnHistory;
    }

    public void setTxnHistory(List<TransactionHist> txnHistory) {
        this.txnHistory = txnHistory;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    
    public List<TransactionHist> loadHistory()
    {
        this.txnHistory = new ArrayList<>();
        TransactionHist h1 = new TransactionHist();
        h1.setAmount(100000);
        h1.setFromAccount(12345);
        h1.setToAccount(9876);
        h1.setTxnId(1);
        
        TransactionHist h2 = new TransactionHist();
        h2.setAmount(12767);
        h2.setFromAccount(12345);
        h2.setToAccount(9876);
        h2.setTxnId(2);
        
        
        
        this.txnHistory.add(h1);
        this.txnHistory.add(h2);
        
        return this.txnHistory;
    }
    
}


