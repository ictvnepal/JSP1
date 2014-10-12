/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.handlers;

import com.bo.Blog;
import com.dal.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author forsell
 */
public class BlogHandler {

    public static int insert(Blog blog) throws ClassNotFoundException, SQLException{
        DBConnection connection=new DBConnection();
        String sql="INSERT INTO blogs(blog_title,blog_description,status) VALUES(?,?,?)";
        PreparedStatement stmt=connection.initStatement(sql);
        stmt.setString(1,blog.getBlogTitle());
        stmt.setString(2,blog.getBlogDescription());
        stmt.setBoolean(3,blog.getStatus());
        int result=connection.executeNonQuery();
        connection.close();
        return result;
    }

    public static int update(Blog blog) throws ClassNotFoundException, SQLException{
        DBConnection connection=new DBConnection();
        String sql="UPDATE blogs set=blog_title=?,blog_description=?,status=? WHERE blog_id=?";
        PreparedStatement stmt=connection.initStatement(sql);
        stmt.setString(1,blog.getBlogTitle());
        stmt.setString(2,blog.getBlogDescription());
        stmt.setBoolean(3,blog.getStatus());
        stmt.setInt(4,blog.getBlogId());
        int result=connection.executeNonQuery();
        connection.close();
        return result;
    }    
    
    public static int delete(int id) throws ClassNotFoundException, SQLException{
        
        DBConnection connection=new DBConnection();
        String sql="DELETE FROM blogs WHERE blog_id=?";
        PreparedStatement stmt=connection.initStatement(sql);
        stmt.setInt(1,id);
        int result=connection.executeNonQuery();
        connection.close();
        return result;   
    }    
    
    
    private static Blog mapData(ResultSet rs) throws SQLException{
        Blog blog=new Blog();
        blog.setBlogId(rs.getInt("blog_id"));
        blog.setBlogTitle(rs.getString("blog_title"));
        blog.setBlogDescription(rs.getString("blog_description"));
        blog.setStatus(rs.getBoolean("status"));
        return blog;
    }
    
    public static ArrayList<Blog> getAll() throws SQLException, ClassNotFoundException{
        ArrayList<Blog> blogs=new ArrayList<Blog>();
        DBConnection connection=new DBConnection();
        String sql="SELECT * from blogs";
        PreparedStatement stmt=connection.initStatement(sql);
        
        ResultSet rs=connection.executeReader();
        while(rs.next()){
            Blog blog=mapData(rs);
            blogs.add(blog);
        }
        connection.close();
        return blogs;       
    }
    
    public static Blog getByPK(int id) throws ClassNotFoundException, SQLException{
        Blog blog=null;
        DBConnection connection=new DBConnection();
        String sql="SELECT * from blogs WHERE blog_id=?";
        PreparedStatement stmt=connection.initStatement(sql);
        stmt.setInt(1,id);
        ResultSet rs=connection.executeReader();
        while(rs.next()){
           blog=mapData(rs);
            
        }
        connection.close();
        return blog;    
    }
}
