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
				private int numProvince;
				private int numCanton;
				private int numDistrito;
				private String address;

				public Ubication() {
								this(-1, -1, -1, -1, "");
				}

				public Ubication(int idUbication, int numProvince, int numCanton, int numDistrito, String address) {
								this.idUbication = idUbication;
								this.numProvince = numProvince;
								this.numCanton = numCanton;
								this.numDistrito = numDistrito;
								this.address = address;
				}

				public int getIdUbication() {
								return idUbication;
				}

				public void setIdUbication(int idUbication) {
								this.idUbication = idUbication;
				}
								
				public int getNumProvince() {
								return numProvince;
				}

				public void setNumProvince(int numProvince) {
								this.numProvince = numProvince;
				}

				public int getNumCanton() {
								return numCanton;
				}

				public void setNumCanton(int numCanton) {
								this.numCanton = numCanton;
				}

				public int getNumDistrito() {
								return numDistrito;
				}

				public void setNumDistrito(int numDistrito) {
								this.numDistrito = numDistrito;
				}

				public String getAddress() {
								return address;
				}

				public void setAddress(String address) {
								this.address = address;
				}

}
