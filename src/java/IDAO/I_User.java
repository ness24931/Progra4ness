/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import Model.User;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface I_User {

				public boolean create(User u);

				public List<User> read();

				public boolean update(User u);

				public boolean delete(String u);

				public boolean validate(String u, String pass);
}
