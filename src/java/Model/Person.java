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
public class Person implements Serializable {

	 private String dni;
	 private String name;
	 private String telephone;
	 private String e_mail;
	 private String tradename;
	 private int id_type;
	 private Ubication location;
	 private User user;

	 public Person() {
			this("", "", "", "", "", -1, null, null);
	 }

	 public Person(String dni, String name, String telephone, String e_mail, 
					 String tradename, int id_type, Ubication location, User user) {
			this.dni = dni;
			this.name = name;
			this.telephone = telephone;
			this.e_mail = e_mail;
			this.tradename = tradename;
			this.id_type = id_type;
			this.location = location;
			this.user = user;
	 }

	 public String getDni() {
			return dni;
	 }

	 public void setDni(String dni) {
			this.dni = dni;
	 }

	 public String getName() {
			return name;
	 }

	 public void setName(String name) {
			this.name = name;
	 }

	 public String getTelephone() {
			return telephone;
	 }

	 public void setTelephone(String telephone) {
			this.telephone = telephone;
	 }

	 public String getE_mail() {
			return e_mail;
	 }

	 public void setE_mail(String e_mail) {
			this.e_mail = e_mail;
	 }

	 public String getTradename() {
			return tradename;
	 }

	 public void setTradename(String tradename) {
			this.tradename = tradename;
	 }

	 public int getId_type() {
			return id_type;
	 }

	 public void setId_type(int id_type) {
			this.id_type = id_type;
	 }

	 public Ubication getLocation() {
			return location;
	 }

	 public void setLocation(Ubication location) {
			this.location = location;
	 }

	 public User getUser() {
			return user;
	 }

	 public void setUser(User user) {
			this.user = user;
	 }

}
