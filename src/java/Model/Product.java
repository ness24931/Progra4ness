/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Product implements Serializable {

	 private int id;
	 private String detail;
	 private float price;
	 private Category category;

	 public Product() {
			this(0, "", 0.0f, null);
	 }

	 public Product(int id, String detail, float price, Category category) {
			this.id = id;
			this.detail = detail;
			this.price = price;
			this.category = category;
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

}
