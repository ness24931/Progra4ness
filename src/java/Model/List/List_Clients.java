/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.List;

import Model.Person;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class List_Clients implements Serializable {

	 private List<Person> clientes;

	 public List_Clients() {
			this.clientes = new ArrayList<>();
	 }

	 public List_Clients(List<Person> clientes) {
			this.clientes = clientes;
	 }

	 public List<Person> getClientes() {
			return clientes;
	 }

	 public void setClientes(List<Person> clientes) {
			this.clientes = clientes;
	 }

}
