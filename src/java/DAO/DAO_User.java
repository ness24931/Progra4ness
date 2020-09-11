/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataAccess.DataBase;
import IDAO.I_User;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DAO_User implements I_User {

				private final String c = "insert into user values(?,?);";
				private final String r = "select * from user;";
				//update only password
				private final String u = "update user set password=? where idUser=?;";
				private final String d = "delete from user where idUser=?;";
				private final String s = "select * from user where idUser=? and password=?;";

				@Override
				public boolean create(User u) {
								PreparedStatement ps = null;
								DataBase db = DataBase.getInstance();
								try {
												ps = db.getConnection().prepareStatement(this.c);
												ps.setString(1, u.getUser());
												ps.setString(2, u.getPass());
												if (ps.executeUpdate() > 0) {
																return true;
												}
								} catch (SQLException ex) {
												Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
								}
								return false;
				}

				@Override
				public List<User> read() {
								List<User> list = new ArrayList<>();
								Statement st = null;
								DataBase db = DataBase.getInstance();
								ResultSet rs = null;
								try {
												st = db.getConnection().createStatement();
												rs = st.executeQuery(this.r);
												while (rs.next()) {
																list.add(new User(
																								rs.getString("idUser"),
																								rs.getString("password")
																));
												}
								} catch (SQLException ex) {
												Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
								}
								return list;
				}

				@Override
				public boolean update(User u) {
								PreparedStatement ps = null;
								DataBase db = DataBase.getInstance();
								try {
												ps = db.getConnection().prepareStatement(this.u);
												ps.setString(1, u.getPass());
												ps.setString(2, u.getUser());
												if (ps.executeUpdate() > 0) {
																return true;
												}
								} catch (SQLException ex) {
												Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
								}
								return false;
				}

				@Override
				public boolean delete(String u) {
								PreparedStatement ps = null;
								DataBase db = DataBase.getInstance();
								try {
												ps = db.getConnection().prepareStatement(this.d);
												ps.setString(1, u);
												if (ps.executeUpdate() > 0) {
																return true;
												}
								} catch (SQLException ex) {
												Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
								}
								return false;
				}

				@Override
				public boolean validate(String u, String pass) {
								PreparedStatement ps = null;
								DataBase db = DataBase.getInstance();
								ResultSet rs = null;
								try {
												ps = db.getConnection().prepareStatement(this.s);
												ps.setString(1, u);
												ps.setString(2, pass);
												rs = ps.executeQuery();
												if (rs.next()) {
																return true;
												}
								} catch (SQLException ex) {
												Logger.getLogger(DAO_User.class.getName()).log(Level.SEVERE, null, ex);
								}
								return false;
				}

				public static void main(String[] args) {
								DAO_User dao = new DAO_User();
								if (dao.create(new User("ness2493", "12345")) == true) {
												System.out.println("insertado");
								} else {
												System.out.println("no insertado");
								}
//								if (dao.update(new User("ness2493", "2493"))) {
//												System.out.println("actualizado");
//								} else {
//												System.out.println("no actualizado");
//								}
//								if (dao.validate("ness2493", "2493")) {
//												System.out.println("si existe");
//												if (dao.delete("ness2493")) {
//																System.out.println("eliminado");
//												} else {
//																System.out.println("no eliminado");
//												}
//								} else {
//												System.out.println("no existe");
//								}
				}

}
