package Model;

import java.io.Serializable;
import java.util.List;

public class Transmitter extends Person implements Serializable {

	 private String tradename;
	 private User user;
	 private List<Product> products;

	 public Transmitter() {
			this("", null, null, "", "", "", "", -1, null);
	 }

	 public Transmitter(String tradename, User user, List<Product> products, String dni,
					 String name, String telephone, String e_mail, int id_type, Ubication location) {
			super(dni, name, telephone, e_mail, id_type, location);
			this.tradename = tradename;
			this.user = user;
			this.products = products;
	 }

	 public String getTradename() {
			return tradename;
	 }

	 public void setTradename(String tradename) {
			this.tradename = tradename;
	 }

	 public User getUser() {
			return user;
	 }

	 public void setUser(User user) {
			this.user = user;
	 }

	 public List<Product> getProducts() {
			return products;
	 }

	 public void setProducts(List<Product> products) {
			this.products = products;
	 }
}
