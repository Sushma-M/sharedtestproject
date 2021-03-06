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
 * OrderdetailsId generated by hbm2java
 */
@Embeddable
public class OrderdetailsId  implements java.io.Serializable {

    
    private Integer orderNumber;
    
    private String productCode;

    public OrderdetailsId() {
    }


    public Integer getOrderNumber() {
        return this.orderNumber;
    }
    
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
    public String getProductCode() {
        return this.productCode;
    }
    
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof OrderdetailsId) )
		    return false;

		 OrderdetailsId that = (OrderdetailsId) o;

         return ( (this.getOrderNumber()==that.getOrderNumber()) || ( this.getOrderNumber()!=null && that.getOrderNumber()!=null && this.getOrderNumber().equals(that.getOrderNumber()) ) )
 && ( (this.getProductCode()==that.getProductCode()) || ( this.getProductCode()!=null && that.getProductCode()!=null && this.getProductCode().equals(that.getProductCode()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getOrderNumber() == null ? 0 : this.getOrderNumber().hashCode() );
         result = 37 * result + ( getProductCode() == null ? 0 : this.getProductCode().hashCode() );

         return result;
    }


}

