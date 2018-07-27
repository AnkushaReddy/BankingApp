/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minions.ejb;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author akamredd
 */
@Entity
@Table(name = "TRANSACTION_HISTIRY")
@NamedQueries({
    @NamedQuery(name = "TransactionHistiry.findAll", query = "SELECT t FROM TransactionHistiry t")
    , @NamedQuery(name = "TransactionHistiry.findByTransactionId", query = "SELECT t FROM TransactionHistiry t WHERE t.transactionId = :transactionId")
    , @NamedQuery(name = "TransactionHistiry.findByBeneficiaryAccId", query = "SELECT t FROM TransactionHistiry t WHERE t.beneficiaryAccId = :beneficiaryAccId")
    , @NamedQuery(name = "TransactionHistiry.findByTransactionDate", query = "SELECT t FROM TransactionHistiry t WHERE t.transactionDate = :transactionDate")
    , @NamedQuery(name = "TransactionHistiry.findByAccountHolderName", query = "SELECT t FROM TransactionHistiry t WHERE t.accountHolderName = :accountHolderName")
    , @NamedQuery(name = "TransactionHistiry.findByIfsc", query = "SELECT t FROM TransactionHistiry t WHERE t.ifsc = :ifsc")
    , @NamedQuery(name = "TransactionHistiry.findByIsIntra", query = "SELECT t FROM TransactionHistiry t WHERE t.isIntra = :isIntra")
    , @NamedQuery(name = "TransactionHistiry.findByAmount", query = "SELECT t FROM TransactionHistiry t WHERE t.amount = :amount")})
public class TransactionHistiry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSACTION_ID")
    private Integer transactionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BENEFICIARY_ACC_ID")
    private int beneficiaryAccId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSACTION_DATE")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "TRANSACTION_TYPE")
    private String transactionType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "ACCOUNT_HOLDER_NAME")
    private String accountHolderName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "IFSC")
    private String ifsc;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "mode")
    private String mode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_INTRA")
    private Character isIntra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AMOUNT")
    private int amount;
    @JoinColumn(name = "ACCOUNT_NUMBER", referencedColumnName = "ACCOUNT_NUMBER")
    @ManyToOne(optional = false)
    private Account accountNumber;

    public TransactionHistiry() {
    }

    public TransactionHistiry(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionHistiry(Integer transactionId, int beneficiaryAccId, Date transactionDate, String transactionType, String accountHolderName, String ifsc, String mode, Character isIntra, int amount) {
        this.transactionId = transactionId;
        this.beneficiaryAccId = beneficiaryAccId;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.accountHolderName = accountHolderName;
        this.ifsc = ifsc;
        this.mode = mode;
        this.isIntra = isIntra;
        this.amount = amount;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public int getBeneficiaryAccId() {
        return beneficiaryAccId;
    }

    public void setBeneficiaryAccId(int beneficiaryAccId) {
        this.beneficiaryAccId = beneficiaryAccId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Character getIsIntra() {
        return isIntra;
    }

    public void setIsIntra(Character isIntra) {
        this.isIntra = isIntra;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Account getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Account accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionHistiry)) {
            return false;
        }
        TransactionHistiry other = (TransactionHistiry) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.minions.ejb.TransactionHistiry[ transactionId=" + transactionId + " ]";
    }
    
}
