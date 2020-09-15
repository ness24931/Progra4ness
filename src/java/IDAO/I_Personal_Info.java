/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import Model.Person;

/**
 *
 * @author ADMIN
 */
public interface I_Personal_Info {

	 public boolean create(Person p);

	 public Person search(String id);

	 public boolean update(Person p);

	 public boolean delete(String id);

}
