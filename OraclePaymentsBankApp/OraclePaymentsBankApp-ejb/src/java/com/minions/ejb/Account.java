/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minions.ejb;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author akamredd
 */
@Entity
@Table(name = "ACCOUNT")
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
    , @NamedQuery(name = "Account.findByAccountNumber", query = "SELECT a FROM Account a WHERE a.accountNumber = :accountNumber")
    , @NamedQuery(name = "Account.findByBalance", query = "SELECT a FROM Account a WHERE a.balance = :balance")
    , @NamedQuery(name = "Account.findByMiniBalance", query = "SELECT a FROM Account a WHERE a.miniBalance = :miniBalance")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCOUNT_NUMBER")
    private Integer accountNumber;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "ACCOUNT_TYPE")
    private String accountType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BALANCE")
    private int balance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MINI_BALANCE")
    private int miniBalance;
    @JoinTable(name = "CUSTOMER_ACCOUNT_REL", joinColumns = {
        @JoinColumn(name = "ACCOUNT_NUMBER", referencedColumnName = "ACCOUNT_NUMBER")}, inverseJoinColumns = {
        @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")})
    @ManyToMany
    private Collection<Customer> customerCollection;
    @JoinColumn(name = "BRANCH_ID", referencedColumnName = "BRANCH_ID")
    @ManyToOne(optional = false)
    private Branch branchId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountNumber")
    private Collection<TransactionHistiry> transactionHistiryCollection;

    public Account() {
    }

    public Account(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Account(Integer accountNumber, String accountType, int balance, int miniBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.miniBalance = miniBalance;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getMiniBalance() {
        return miniBalance;
    }

    public void setMiniBalance(int miniBalance) {
        this.miniBalance = miniBalance;
    }

    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    public Branch getBranchId() {
        return branchId;
    }

    public void setBranchId(Branch branchId) {
        this.branchId = branchId;
    }

    public Collection<TransactionHistiry> getTransactionHistiryCollection() {
        return transactionHistiryCollection;
    }

    public void setTransactionHistiryCollection(Collection<TransactionHistiry> transactionHistiryCollection) {
        this.transactionHistiryCollection = transactionHistiryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountNumber != null ? accountNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountNumber == null && other.accountNumber != null) || (this.accountNumber != null && !this.accountNumber.equals(other.accountNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.minions.ejb.Account[ accountNumber=" + accountNumber + " ]";
    }
    
}
