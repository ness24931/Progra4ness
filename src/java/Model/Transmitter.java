/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class Transmitter implements Serializable {

    private String id;
    private String name;
    private String email;
    private String tradename;
    private int id_type;
    private Ubication ubication;
    private List<Product> products;

    public Transmitter() {
        this("", "", "", "", -1, null, null);
    }

    public Transmitter(String id, String name, String email, String tradename, int id_type, Ubication ubication, List<Product> products) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tradename = tradename;
        this.id_type = id_type;
        this.ubication = ubication;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Ubication getUbication() {
        return ubication;
    }

    public void setUbication(Ubication ubication) {
        this.ubication = ubication;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
