/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bo;

/**
 *
 * @author forsell
 */
public class Blog {
    
    private int blogId;
    private String blogTitle;
    private String blogDescription;
    private boolean status;

    public Blog() {
    }

    public Blog(int blogId, String blogTitle, String blogDescription, boolean status) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.blogDescription = blogDescription;
        this.status = status;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Blog{" + "blogId=" + blogId + ", blogTitle=" + blogTitle + ", blogDescription=" + blogDescription + ", status=" + status + '}';
    }
    
    

}
