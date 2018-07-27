/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.training.bankapp.managedbean;

/**
 *
 * @author neeshukl
 */
public class TransactionHist {
    
    private int txnId;
        private int fromAccount;
        private int toAccount;
        private double amount;

        public TransactionHist() {
        }

        public int getTxnId() {
            return txnId;
        }

        public void setTxnId(int txnId) {
            this.txnId = txnId;
        }

        public int getFromAccount() {
            return fromAccount;
        }

        public void setFromAccount(int fromAccount) {
            this.fromAccount = fromAccount;
        }

        public int getToAccount() {
            return toAccount;
        }

        public void setToAccount(int toAccount) {
            this.toAccount = toAccount;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
