/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Logic.User;

/**
 *
 * @author Emanuel Barrantes Guzmán
 */
public class Model_login {

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    private User user;

    public Model_login() {
        this.reset();
    }

    public void reset() {
        setUser(new User());
    }
}
