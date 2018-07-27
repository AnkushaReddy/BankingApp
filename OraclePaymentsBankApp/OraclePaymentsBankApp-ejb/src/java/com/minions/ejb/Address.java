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
@Table(name = "ADDRESS")
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
    , @NamedQuery(name = "Address.findByAddressId", query = "SELECT a FROM Address a WHERE a.addressId = :addressId")
    , @NamedQuery(name = "Address.findByStreetLine1", query = "SELECT a FROM Address a WHERE a.streetLine1 = :streetLine1")
    , @NamedQuery(name = "Address.findByStreetLine2", query = "SELECT a FROM Address a WHERE a.streetLine2 = :streetLine2")
    , @NamedQuery(name = "Address.findByTown", query = "SELECT a FROM Address a WHERE a.town = :town")
    , @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city")
    , @NamedQuery(name = "Address.findByState", query = "SELECT a FROM Address a WHERE a.state = :state")
    , @NamedQuery(name = "Address.findByCountry", query = "SELECT a FROM Address a WHERE a.country = :country")
    , @NamedQuery(name = "Address.findByPin", query = "SELECT a FROM Address a WHERE a.pin = :pin")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADDRESS_ID")
    private Integer addressId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "STREET_LINE_1")
    private String streetLine1;
    @Size(max = 50)
    @Column(name = "STREET_LINE_2")
    private String streetLine2;
    @Size(max = 50)
    @Column(name = "TOWN")
    private String town;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "STATE")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "COUNTRY")
    private String country;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PIN")
    private int pin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId")
    private Collection<Branch> branchCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId")
    private Collection<Bank> bankCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId")
    private Collection<Customer> customerCollection;

    public Address() {
    }

    public Address(Integer addressId) {
        this.addressId = addressId;
    }

    public Address(Integer addressId, String streetLine1, String city, String state, String country, int pin) {
        this.addressId = addressId;
        this.streetLine1 = streetLine1;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pin = pin;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getStreetLine1() {
        return streetLine1;
    }

    public void setStreetLine1(String streetLine1) {
        this.streetLine1 = streetLine1;
    }

    public String getStreetLine2() {
        return streetLine2;
    }

    public void setStreetLine2(String streetLine2) {
        this.streetLine2 = streetLine2;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Collection<Branch> getBranchCollection() {
        return branchCollection;
    }

    public void setBranchCollection(Collection<Branch> branchCollection) {
        this.branchCollection = branchCollection;
    }

    public Collection<Bank> getBankCollection() {
        return bankCollection;
    }

    public void setBankCollection(Collection<Bank> bankCollection) {
        this.bankCollection = bankCollection;
    }

    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.minions.ejb.Address[ addressId=" + addressId + " ]";
    }
    
}
