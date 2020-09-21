/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataAccess.DataBase;
import Model.Person;
import Model.Ubication;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import IDAO.I_Person;
import Model.List.List_Clients;

/**
 *
 * @author ADMIN
 */
public class DAO_Person implements I_Person {

	 private String create = "insert into receiver values(?,?,?,?,?,?,?);";
	 private String search = "select * from personal_info where dni=?;";
	 private String update = "update personal_info set name = ?, telephone =?, e-mail =?, tradename =?, location int \n"
					 + "id_type int \n"
					 + "user ?,?,?,?,?,?,?,?);";
	 private String searchClient = "SELECT * FROM eif209_2020_p01.receiver r inner join "
					 + "ubication u on r.location = u.idUbication and r.transmitter_owner = ?;";

	 @Override
	 public boolean create(Person p, String owner) {
			PreparedStatement ps = null;
			DataBase db = DataBase.getInstance();
			try {
				 ps = db.getConnection().prepareStatement(create);
				 ps.setString(1, p.getDni());
				 ps.setString(2, p.getName());
				 ps.setString(3, p.getTelephone());
				 ps.setString(4, p.getE_mail());
				 ps.setInt(5, p.getLocation().getIdUbication());
				 ps.setInt(6, p.getId_type());
				 ps.setString(7, owner);
				 if (ps.executeUpdate() > 0) {
						return true;
				 }
			} catch (SQLException ex) {
				 Logger.getLogger(DAO_Person.class.getName()).log(Level.SEVERE, null, ex);
			}
			return false;
	 }

	 @Override
	 public Person search(String id) {
			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	 }

	 @Override
	 public boolean update(Person p) {
			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	 }

	 @Override
	 public boolean delete(String id) {
			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	 }

	 @Override
	 public List_Clients searchClients(String owner) {
			List_Clients clientes = new List_Clients();
			PreparedStatement ps = null;
			DataBase db = DataBase.getInstance();
			ResultSet rs = null;
			try {
				 ps = db.getConnection().prepareStatement(this.searchClient);
				 ps.setString(1, owner);
				 rs = ps.executeQuery();
				 while (rs.next()) {
						clientes.getClientes().add(
										new Person(
														rs.getString(1),
														rs.getString(2),
														rs.getString(3),
														rs.getString(4),
														rs.getInt(6),
														new Ubication(
																		rs.getInt(8),
																		rs.getString(9),
																		rs.getString(10),
																		rs.getString(11),
																		rs.getString(12))
										));
				 }
			} catch (SQLException ex) {
				 Logger.getLogger(DAO_Person.class.getName()).log(Level.SEVERE, null, ex);
			}
			if (clientes.getClientes().isEmpty()) {
				 return null;
			} else {
				 return clientes;
			}
	 }

}
