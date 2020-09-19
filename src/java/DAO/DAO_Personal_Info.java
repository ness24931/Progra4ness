/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataAccess.DataBase;
import IDAO.I_Personal_Info;
import Model.Person;
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
public class DAO_Personal_Info implements I_Personal_Info {

	 private String create = "insert into personal_info values(?,?,?,?,?,?,?,?);";
	 private String search = "select * from personal_info where dni=?;";
	 private String update = "update personal_info set name = ?, telephone =?, e-mail =?, tradename =?, location int \n"
					 + "id_type int \n"
					 + "user ?,?,?,?,?,?,?,?);";
	 private String searchUser = "SELECT * FROM eif209_2020_p01.personal_info p inner join "
					 + "ubication l on p.location = l.idUbication right join "
					 + "identification i on p.id_type = i.Tipo where p.user=?;";

	 @Override
	 public boolean create(Person p) {
			PreparedStatement ps = null;
			DataBase db = DataBase.getInstance();
			try {
				 ps = db.getConnection().prepareStatement(create);
				 ps.setString(1, p.getDni());
				 ps.setString(2, p.getName());
				 ps.setString(3, p.getTelephone());
				 ps.setString(4, p.getE_mail());
				 ps.setString(5, p.getTradename());
				 ps.setInt(6, p.getLocation().getIdUbication());
				 ps.setInt(7, p.getId_type());
				 ps.setString(8, p.getUser().getUser());
				 if (ps.executeUpdate() > 0) {
						return true;
				 }
			} catch (SQLException ex) {
				 Logger.getLogger(DAO_Personal_Info.class.getName()).log(Level.SEVERE, null, ex);
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
	 public Person searchUser(String user) {
			PreparedStatement ps = null;
			DataBase db = DataBase.getInstance();
			ResultSet rs = null;
			Person person = null;
			try {
				 ps = db.getConnection().prepareStatement(this.searchUser);
				 ps.setString(1, user);
				 rs = ps.executeQuery();
				 if (rs.next()) {
						person = new Person(
										rs.getString("dni"),
										rs.getString("name"),
										rs.getString("telephone"),
										rs.getString("e-mail"),
										rs.getString("tradename"),
										rs.getInt("id_type"),
										new Ubication(
														rs.getInt("idUbication"),
														rs.getString("nomProvince"),
														rs.getString("nomCanton"),
														rs.getString("nomDistrito"),
														rs.getString("address")),
										new User(user, ""));
				 }
			} catch (SQLException ex) {
				 Logger.getLogger(DAO_Personal_Info.class.getName()).log(Level.SEVERE, null, ex);
			}
			return person;
	 }

}
