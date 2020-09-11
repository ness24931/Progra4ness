/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author Emanuel Barrantes Guzmán
 */
public class User {

    /**
     * @return the id_user
     */
    public String getId_user() {
        return id_user;
    }

    /**
     * @param id_user the id_user to set
     */
    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    private String id_user;
    private String password;
   model model;
    public User(String id_user,String password)
    {
        this.id_user=id_user;
        this.password=password;
    }
    public User()
    {
        
    }
}
