package Model;

import java.io.Serializable;

public class Person implements Serializable {

	 private String dni;
	 private String name;
	 private String telephone;
	 private String e_mail;

	 private int id_type;
	 private Ubication location;

	 public Person() {
			this("", "", "", "", -1, null);
	 }

	 public Person(String dni, String name, String telephone, String e_mail,
					 int id_type, Ubication location) {
			this.dni = dni;
			this.name = name;
			this.telephone = telephone;
			this.e_mail = e_mail;
			this.id_type = id_type;
			this.location = location;

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
}
