/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Factura implements Serializable {

	 private Transmitter emisor;
	 private Person cliente;
	 private ListProduct productos;

	 public Factura() {
			this(null, null);
			this.productos = null;
	 }

	 public Factura(Transmitter emisor, Person cliente) {
			this.emisor = emisor;
			this.cliente = cliente;
			this.productos = new ListProduct();
	 }

	 public Factura(Transmitter emisor, Person cliente, ListProduct productos) {
			this.emisor = emisor;
			this.cliente = cliente;
			this.productos = productos;
	 }

	 public Transmitter getEmisor() {
			return emisor;
	 }

	 public void setEmisor(Transmitter emisor) {
			this.emisor = emisor;
	 }

	 public Person getCliente() {
			return cliente;
	 }

	 public void setCliente(Person cliente) {
			this.cliente = cliente;
	 }

	 public ListProduct getProductos() {
			return productos;
	 }

	 public void setProductos(ListProduct productos) {
			this.productos = productos;
	 }
	 
	 public float getTotal(){
			return this.productos.total();
	 }
}
