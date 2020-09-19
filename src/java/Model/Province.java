/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author ADMIN
 */
public class Province implements Serializable {

	 private String name;
	 private List<Canton> cantons;

	 public Province() {
			this.cantons = new ArrayList<>();
	 }

	 public Province(String nombre) {
			this.name = nombre;
			this.cantons = new ArrayList<>();
	 }

	 public Province(String name, List<Canton> cantons) {
			this.name = name;
			this.cantons = cantons;
	 }

	 public String getName() {
			return name;
	 }

	 public void setName(String name) {
			this.name = name;
	 }

	 public List<Canton> getCantons() {
			return this.cantons;
	 }

	 public void setCantones(List<Canton> canton) {
			this.cantons = canton;
	 }

	 @Override
	 public String toString() {
			String texto = "Provincia{ nombre=" + name + ", cantones=\n";
			for (Canton c : cantons) {
				 texto += "\t" + c.toString() + "\n";
			}
			texto += '}';
			return texto;
	 }
}
