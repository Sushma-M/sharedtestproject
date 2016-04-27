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
 * ArticleTagsId generated by hbm2java
 */
@Embeddable
public class ArticleTagsId  implements java.io.Serializable {

    
    private Integer articleId;
    
    private Integer tagId;

    public ArticleTagsId() {
    }


    public Integer getArticleId() {
        return this.articleId;
    }
    
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
    public Integer getTagId() {
        return this.tagId;
    }
    
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof ArticleTagsId) )
		    return false;

		 ArticleTagsId that = (ArticleTagsId) o;

         return ( (this.getArticleId()==that.getArticleId()) || ( this.getArticleId()!=null && that.getArticleId()!=null && this.getArticleId().equals(that.getArticleId()) ) )
 && ( (this.getTagId()==that.getTagId()) || ( this.getTagId()!=null && that.getTagId()!=null && this.getTagId().equals(that.getTagId()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getArticleId() == null ? 0 : this.getArticleId().hashCode() );
         result = 37 * result + ( getTagId() == null ? 0 : this.getTagId().hashCode() );

         return result;
    }


}

