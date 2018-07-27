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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author akamredd
 */
@Entity
@Table(name = "BRANCH")
@NamedQueries({
    @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b")
    , @NamedQuery(name = "Branch.findByBranchId", query = "SELECT b FROM Branch b WHERE b.branchId = :branchId")
    , @NamedQuery(name = "Branch.findByBranchName", query = "SELECT b FROM Branch b WHERE b.branchName = :branchName")
    , @NamedQuery(name = "Branch.findByBranchAddress", query = "SELECT b FROM Branch b WHERE b.branchAddress = :branchAddress")
    , @NamedQuery(name = "Branch.findByIfsc", query = "SELECT b FROM Branch b WHERE b.ifsc = :ifsc")
    , @NamedQuery(name = "Branch.findByPhone", query = "SELECT b FROM Branch b WHERE b.phone = :phone")})
public class Branch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BRANCH_ID")
    private Integer branchId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "BRANCH_NAME")
    private String branchName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BRANCH_ADDRESS")
    private int branchAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "IFSC")
    private String ifsc;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "PHONE")
    private String phone;
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    @ManyToOne(optional = false)
    private Address addressId;
    @JoinColumn(name = "BANK_ID", referencedColumnName = "BANK_ID")
    @ManyToOne(optional = false)
    private Bank bankId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchId")
    private Collection<Account> accountCollection;

    public Branch() {
    }

    public Branch(Integer branchId) {
        this.branchId = branchId;
    }

    public Branch(Integer branchId, String branchName, int branchAddress, String ifsc) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.branchAddress = branchAddress;
        this.ifsc = ifsc;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(int branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public Bank getBankId() {
        return bankId;
    }

    public void setBankId(Bank bankId) {
        this.bankId = bankId;
    }

    public Collection<Account> getAccountCollection() {
        return accountCollection;
    }

    public void setAccountCollection(Collection<Account> accountCollection) {
        this.accountCollection = accountCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchId != null ? branchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.branchId == null && other.branchId != null) || (this.branchId != null && !this.branchId.equals(other.branchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.minions.ejb.Branch[ branchId=" + branchId + " ]";
    }
    
}
