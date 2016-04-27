/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.sharedtestproject.classicmodels;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Embeddable;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * PaymentsId generated by hbm2java
 */
@Embeddable
public class PaymentsId  implements java.io.Serializable {

    
    private Integer customerNumber;
    
    private String checkNumber;

    public PaymentsId() {
    }


    public Integer getCustomerNumber() {
        return this.customerNumber;
    }
    
    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }
    public String getCheckNumber() {
        return this.checkNumber;
    }
    
    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof PaymentsId) )
		    return false;

		 PaymentsId that = (PaymentsId) o;

         return ( (this.getCustomerNumber()==that.getCustomerNumber()) || ( this.getCustomerNumber()!=null && that.getCustomerNumber()!=null && this.getCustomerNumber().equals(that.getCustomerNumber()) ) )
 && ( (this.getCheckNumber()==that.getCheckNumber()) || ( this.getCheckNumber()!=null && that.getCheckNumber()!=null && this.getCheckNumber().equals(that.getCheckNumber()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getCustomerNumber() == null ? 0 : this.getCustomerNumber().hashCode() );
         result = 37 * result + ( getCheckNumber() == null ? 0 : this.getCheckNumber().hashCode() );

         return result;
    }


}

