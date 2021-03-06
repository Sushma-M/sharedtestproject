/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.sharedtestproject.classicmodels;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * Customers generated by hbm2java
 */
@Entity
@Table(name="`customers`"
)

public class Customers  implements java.io.Serializable {

    
    private Integer customerNumber;
    
    private String customerName;
    
    private String contactLastName;
    
    private String contactFirstName;
    
    private String phone;
    
    private String addressLine1;
    
    private String addressLine2;
    
    private String city;
    
    private String state;
    
    private String postalCode;
    
    private String country;
    
    private BigDecimal creditLimit;
    
    private Set<Payments> paymentses = new HashSet<Payments>(0);
    
    private Set<Orders> orderses = new HashSet<Orders>(0);
    
    private Employees employees;

    public Customers() {
    }


    @Id 
    

    @Column(name="`customerNumber`", precision=10)
    public Integer getCustomerNumber() {
        return this.customerNumber;
    }
    
    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    

    @Column(name="`customerName`", length=50)
    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    

    @Column(name="`contactLastName`", length=50)
    public String getContactLastName() {
        return this.contactLastName;
    }
    
    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    

    @Column(name="`contactFirstName`", length=50)
    public String getContactFirstName() {
        return this.contactFirstName;
    }
    
    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    

    @Column(name="`phone`", length=50)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    

    @Column(name="`addressLine1`", length=50)
    public String getAddressLine1() {
        return this.addressLine1;
    }
    
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    

    @Column(name="`addressLine2`", length=50)
    public String getAddressLine2() {
        return this.addressLine2;
    }
    
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    

    @Column(name="`city`", length=50)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    

    @Column(name="`state`", length=50)
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    

    @Column(name="`postalCode`", length=15)
    public String getPostalCode() {
        return this.postalCode;
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    

    @Column(name="`country`", length=50)
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }

    

    @Column(name="`creditLimit`", precision=22, scale=9)
    public BigDecimal getCreditLimit() {
        return this.creditLimit;
    }
    
    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="customers")
    public Set<Payments> getPaymentses() {
        return this.paymentses;
    }
    
    public void setPaymentses(Set<Payments> paymentses) {
        this.paymentses = paymentses;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="customers")
    public Set<Orders> getOrderses() {
        return this.orderses;
    }
    
    public void setOrderses(Set<Orders> orderses) {
        this.orderses = orderses;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`salesRepEmployeeNumber`")
    public Employees getEmployees() {
        return this.employees;
    }
    
    public void setEmployees(Employees employees) {
        this.employees = employees;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof Customers) )
		    return false;

		 Customers that = (Customers) o;

		 return ( (this.getCustomerNumber()==that.getCustomerNumber()) || ( this.getCustomerNumber()!=null && that.getCustomerNumber()!=null && this.getCustomerNumber().equals(that.getCustomerNumber()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getCustomerNumber() == null ? 0 : this.getCustomerNumber().hashCode() );

         return result;
    }


}

