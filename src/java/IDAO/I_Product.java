/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import Model.Product;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ADMIN
 */
public interface I_Product {

    boolean create(Product p, String owner);

    List<Product> read(String owner);

    boolean update(Product p, String owner);

    Optional<Product> delete(String id, String owner);
//				Optional<Product> search();

}
