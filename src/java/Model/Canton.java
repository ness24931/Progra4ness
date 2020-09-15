/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Canton {

	 private String nombre;
	 private List<District> district;

	 public Canton() {
			this("");
	 }

	 public Canton(String nombre) {
			this.nombre = nombre;
			this.district = new ArrayList<>();
	 }

	 public String getNombre() {
			return nombre;
	 }

	 public void setNombre(String nombre) {
			this.nombre = nombre;
	 }

	 public List<District> getDistritos() {
			return district;
	 }

	 public void setDistritos(List<District> distritos) {
			this.district = distritos;
	 }

	 @Override
	 public String toString() {
			String texto = "\tCanton{ nombre=" + nombre + ", distritos=\n";
			for (District d : district) {
				 texto += "\t\t" + d.toString() + "\n";
			}
			texto += '}';
			return texto;
	 }

}
