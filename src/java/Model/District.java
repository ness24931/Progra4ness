/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ADMIN
 */
public class District {

	 private String name;

	 public District() {
			this("");
	 }

	 public District(String nombre) {
			this.name = nombre;
	 }

	 public String getName() {
			return name;
	 }

	 public void setName(String name) {
			this.name = name;
	 }

	 @Override
	 public String toString() {
			return "\tDistrito{ nombre=" + name + '}';
	 }

}
