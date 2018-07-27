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
@Table(name = "BANK")
@NamedQueries({
    @NamedQuery(name = "Bank.findAll", query = "SELECT b FROM Bank b")
    , @NamedQuery(name = "Bank.findByBankId", query = "SELECT b FROM Bank b WHERE b.bankId = :bankId")
    , @NamedQuery(name = "Bank.findByMail", query = "SELECT b FROM Bank b WHERE b.mail = :mail")
    , @NamedQuery(name = "Bank.findByPhone", query = "SELECT b FROM Bank b WHERE b.phone = :phone")
    , @NamedQuery(name = "Bank.findByBankName", query = "SELECT b FROM Bank b WHERE b.bankName = :bankName")})
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BANK_ID")
    private Integer bankId;
    @Size(max = 50)
    @Column(name = "MAIL")
    private String mail;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "PHONE")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "BANK_NAME")
    private String bankName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankId")
    private Collection<Branch> branchCollection;
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    @ManyToOne(optional = false)
    private Address addressId;

    public Bank() {
    }

    public Bank(Integer bankId) {
        this.bankId = bankId;
    }

    public Bank(Integer bankId, String bankName) {
        this.bankId = bankId;
        this.bankName = bankName;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Collection<Branch> getBranchCollection() {
        return branchCollection;
    }

    public void setBranchCollection(Collection<Branch> branchCollection) {
        this.branchCollection = branchCollection;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankId != null ? bankId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bank)) {
            return false;
        }
        Bank other = (Bank) object;
        if ((this.bankId == null && other.bankId != null) || (this.bankId != null && !this.bankId.equals(other.bankId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.minions.ejb.Bank[ bankId=" + bankId + " ]";
    }
    
}
