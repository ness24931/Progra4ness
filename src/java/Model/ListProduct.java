/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Optional;

public class ListProduct extends ArrayList<Product> {

	 public ListProduct() {
			super();
	 }

	 public float total() {
			float t = this.stream().map(element -> element.getTotal())
							.reduce(0.0f, (total, detalle) -> total + detalle);
			return t;
	 }

	 public Product search(int id) {
			Optional<Product> optional = this.stream().filter(elem -> elem.getId() == id).findFirst();
			if (optional.isPresent()) {
				 return optional.get();
			} else {
				 return null;
			}
	 }

	 public static void main(String[] args) {
			ListProduct lista = new ListProduct();
			Product prod1 = new Product(0, "hola0", 550, new Category("saludo1", 0.13f));
			Product prod2 = new Product(1, "hola1", 650, new Category("saludo2", 0.12f));
			Product prod3 = new Product(2, "hola2", 750, new Category("saludo3", 0.11f));
			Product prod4 = new Product(3, "hola3", 850, new Category("saludo4", 0.10f));
			lista.add(prod1);
			lista.add(prod2);
			lista.add(prod3);
			lista.add(prod4);
			System.out.println(lista.total());
	 }
}
