/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import Model.Person;
import Model.Product;
import Model.Transmitter;

/**
 *
 * @author ADMIN
 */
public interface I_Transmitter {

	 public boolean create(Transmitter emisor);

	 public Transmitter search(String user);

}
