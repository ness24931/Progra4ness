package Model;

import java.io.Serializable;

public class Product implements Serializable {

	 private int id;
	 private String detail;
	 private float price;
	 private Category category;
	 private int cantidad;

	 public Product() {
			this(0, "", 0.0f, null);
			this.cantidad = 0;
	 }

	 public Product(int id, String detail, float price, Category category) {
			this.id = id;
			this.detail = detail;
			this.price = price;
			this.category = category;
			this.cantidad = 0;
	 }

	 public int getId() {
			return id;
	 }

	 public void setId(int id) {
			this.id = id;
	 }

	 public String getDetail() {
			return detail;
	 }

	 public void setDetail(String detail) {
			this.detail = detail;
	 }

	 public float getPrice() {
			return price;
	 }

	 public void setPrice(float price) {
			this.price = price;
	 }

	 public Category getCategory() {
			return category;
	 }

	 public void setCategory(Category category) {
			this.category = category;
	 }

	 public int getCantidad() {
			return cantidad;
	 }

	 public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
	 }

	 public float getTotal() {
			float a = this.price * this.cantidad;
			float b = a * this.category.getIva();
			return a + b;
	 }

}
