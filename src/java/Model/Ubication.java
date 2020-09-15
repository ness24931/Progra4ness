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
public class Ubication implements Serializable {

	 private int idUbication;
	 private String province;
	 private String canton;
	 private String distrito;
	 private String address;

	 public Ubication() {
			this(0, "", "", "", "");
	 }

	 public Ubication(int idUbication, String province, String canton, String distrito, String address) {
			this.idUbication = idUbication;
			this.province = province;
			this.canton = canton;
			this.distrito = distrito;
			this.address = address;
	 }

	 public int getIdUbication() {
			return idUbication;
	 }

	 public void setIdUbication(int idUbication) {
			this.idUbication = idUbication;
	 }

	 public String getProvince() {
			return province;
	 }

	 public void setProvince(String province) {
			this.province = province;
	 }

	 public String getCanton() {
			return canton;
	 }

	 public void setCanton(String canton) {
			this.canton = canton;
	 }

	 public String getDistrito() {
			return distrito;
	 }

	 public void setDistrito(String distrito) {
			this.distrito = distrito;
	 }

	 public String getAddress() {
			return address;
	 }

	 public void setAddress(String address) {
			this.address = address;
	 }

}
