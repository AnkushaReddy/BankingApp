/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minions.ejb;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "CUSTOMER")
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByCustomerId", query = "SELECT c FROM Customer c WHERE c.customerId = :customerId")
    , @NamedQuery(name = "Customer.findByCustomerName", query = "SELECT c FROM Customer c WHERE c.customerName = :customerName")
    , @NamedQuery(name = "Customer.findByDob", query = "SELECT c FROM Customer c WHERE c.dob = :dob")
    , @NamedQuery(name = "Customer.findByPhone", query = "SELECT c FROM Customer c WHERE c.phone = :phone")
    , @NamedQuery(name = "Customer.findByPassword", query = "SELECT c FROM Customer c WHERE c.password = :password")
    , @NamedQuery(name = "Customer.findByMail", query = "SELECT c FROM Customer c WHERE c.mail = :mail")
    , @NamedQuery(name = "Customer.findByAadhar", query = "SELECT c FROM Customer c WHERE c.aadhar = :aadhar")
    , @NamedQuery(name = "Customer.findByOldPassword", query = "SELECT c FROM Customer c WHERE c.oldPassword = :oldPassword")
    , @NamedQuery(name = "Customer.findByOldPasswordTs", query = "SELECT c FROM Customer c WHERE c.oldPasswordTs = :oldPasswordTs")
    , @NamedQuery(name = "Customer.findByTransactionPwd", query = "SELECT c FROM Customer c WHERE c.transactionPwd = :transactionPwd")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private Date dob;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "PHONE")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MAIL")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "AADHAR")
    private String aadhar;
    @Size(max = 15)
    @Column(name = "OLD_PASSWORD")
    private String oldPassword;
    @Column(name = "OLD_PASSWORD_TS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date oldPasswordTs;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "TRANSACTION_PWD")
    private String transactionPwd;
    @ManyToMany(mappedBy = "customerCollection")
    private Collection<Account> accountCollection;
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    @ManyToOne(optional = false)
    private Address addressId;

    public Customer() {
    }

    public Customer(Integer customerId) {
        this.customerId = customerId;
    }

    public Customer(Integer customerId, String customerName, Date dob, String phone, String password, String mail, String aadhar, String transactionPwd) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.dob = dob;
        this.phone = phone;
        this.password = password;
        this.mail = mail;
        this.aadhar = aadhar;
        this.transactionPwd = transactionPwd;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public Date getOldPasswordTs() {
        return oldPasswordTs;
    }

    public void setOldPasswordTs(Date oldPasswordTs) {
        this.oldPasswordTs = oldPasswordTs;
    }

    public String getTransactionPwd() {
        return transactionPwd;
    }

    public void setTransactionPwd(String transactionPwd) {
        this.transactionPwd = transactionPwd;
    }

    public Collection<Account> getAccountCollection() {
        return accountCollection;
    }

    public void setAccountCollection(Collection<Account> accountCollection) {
        this.accountCollection = accountCollection;
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
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.minions.ejb.Customer[ customerId=" + customerId + " ]";
    }
    
}
