/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Transmitter extends Person implements Serializable {

	 private List<Product> products;

	 public Transmitter() {
			super();
			this.products = null;
	 }

	 public Transmitter(List<Product> products) {
			this.products = products;
	 }

	 public List<Product> getProducts() {
			return products;
	 }

	 public void setProducts(List<Product> products) {
			this.products = products;
	 }
}
