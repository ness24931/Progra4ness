/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import DAO.DAO_User;
import java.sql.SQLException;

/**
 *
 * @author Emanuel Barrantes Guzmán
 */
public class model {
    private static model uniqueInstance;
    
    public static model instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new model();
        }
        return uniqueInstance;
    }
    public model()
    {
        
    }
    public User user_find(String id_user,String password) throws SQLException
    {
        User user;
        DAO_User d= new DAO_User();
        user=d.return_User(new User(id_user,password));
        return user;
    }
    //aquí irían todos los agregar, modificar, listar, del usuario
    
}
