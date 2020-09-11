/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Logic.User;
import java.sql.Connection;
import DataAccess.DataBase;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Emanuel Barrantes Guzmán
 */
public class DAO_User {
    
   
    public User return_User(User p) throws SQLException
    {
        User u=null ;
        DataBase bd =DataBase.getInstance();
        String sql="Select * from eif209_2020_p01.user where idUser=? and password =?;";
        
        
        try
        { 
           PreparedStatement st=bd.getConnection().prepareStatement(sql);
           st.setString(1,p.getId_user());
            st.setString(2,p.getPassword());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                u = new User(rs.getString("idUser"),rs.getString("password")); 
               
                
            }
             bd.closeConnection();
         }catch (SQLException e)
         {
             
         }
    return u;
    }

}
