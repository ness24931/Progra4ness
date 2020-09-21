/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataAccess.DataBase;
import IDAO.I_Transmitter;
import Model.Person;
import Model.Product;
import Model.Transmitter;
import Model.Ubication;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DAO_Transmitter implements I_Transmitter {

	 private final String create = "insert into transmitter values(?,?,?,?,?,?,?,?);";
	 private final String search = "select * from transmitter t inner join ubication u on t.location = u.idUbication and user = ?;";

	 @Override
	 public boolean create(Transmitter emisor) {
			PreparedStatement ps = null;
			DataAccess.DataBase db = DataBase.getInstance();
			try {
				 ps = db.getConnection().prepareStatement(create);
				 ps.setString(1, emisor.getDni());
				 ps.setString(2, emisor.getName());
				 ps.setString(3, emisor.getTelephone());
				 ps.setString(4, emisor.getE_mail());
				 ps.setString(5, emisor.getTradename());
				 ps.setInt(6, emisor.getLocation().getIdUbication());
				 ps.setInt(7, emisor.getId_type());
				 ps.setString(8, emisor.getUser().getUser());
				 if (ps.executeUpdate() > 0) {
						return true;
				 }
			} catch (SQLException ex) {
				 Logger.getLogger(DAO_Transmitter.class.getName()).log(Level.SEVERE, null, ex);
			}
			return false;
	 }

	 @Override
	 public Transmitter search(String user) {
			PreparedStatement ps = null;
			DataBase db = DataBase.getInstance();
			ResultSet rs = null;
			Transmitter emisor = null;
			try {
				 ps = db.getConnection().prepareStatement(this.search);
				 ps.setString(1, user);
				 rs = ps.executeQuery();
				 if (rs.next()) {
						emisor = new Transmitter(
										rs.getString("tradename"),
										new User(user, ""),
										null,
										rs.getString("dni"),
										rs.getString("name"),
										rs.getString("telephone"),
										rs.getString("e-mail"),
										rs.getInt("id_type"),
										new Ubication(
														rs.getInt("idUbication"),
														rs.getString("nomProvince"),
														rs.getString("nomCanton"),
														rs.getString("nomDistrito"),
														rs.getString("address"))
						);
				 }
			} catch (SQLException ex) {
				 Logger.getLogger(DAO_Person.class.getName()).log(Level.SEVERE, null, ex);
			}
			return emisor;
	 }

}
