/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataAccess.DataBase;
import IDAO.I_Ubication;
import Model.Ubication;
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
public class DAO_Ubication implements I_Ubication {

				private final String c = "insert into ubication values(0,?,?,?,?)";
				private final String r = "select * from ubication";
				private final String u = "update ubication set numProvince=?,numCanton=?,numDistrito=?,address=? where idUbication=?";
				private final String d = "delete from ubication where idUbication=?";

				@Override
				public boolean create(Ubication u) {
								PreparedStatement ps = null;
								DataBase db = DataBase.getInstance();
								try {
												ps = db.getConnection().prepareStatement(c);
												ps.setInt(1, u.getNumProvince());
												ps.setInt(2, u.getNumCanton());
												ps.setInt(3, u.getNumDistrito());
												ps.setString(4, u.getAddress());
												if (ps.executeUpdate() > 0) {
																return true;
												}
								} catch (SQLException ex) {
												Logger.getLogger(DAO_Ubication.class.getName()).log(Level.SEVERE, null, ex);
								} finally {
												try {
																this.closeCnx(ps, null, null);
												} catch (SQLException ex) {
																Logger.getLogger(DAO_Ubication.class.getName()).log(Level.SEVERE, null, ex);
												}
								}
								return false;
				}

				@Override
				public List<Ubication> read() {
								List<Ubication> list = new ArrayList<>();
								Statement st = null;
								DataBase db = DataBase.getInstance();
								ResultSet rs = null;
								try {
												st = db.getConnection().createStatement();
												rs = st.executeQuery(this.r);
												while (rs.next()) {
																list.add(new Ubication(
																								rs.getInt("idUbication"),
																								rs.getInt("numProvince"),
																								rs.getInt("numCanton"),
																								rs.getInt("numDistrito"),
																								rs.getString("address")
																));
												}
								} catch (SQLException ex) {
												Logger.getLogger(DAO_Ubication.class.getName()).log(Level.SEVERE, null, ex);
								} finally {
												try {
																this.closeCnx(null, st, rs);
												} catch (SQLException ex) {
																Logger.getLogger(DAO_Ubication.class.getName()).log(Level.SEVERE, null, ex);
												}
								}
								return list;
				}

				@Override
				public boolean update(Ubication u) {
								PreparedStatement ps = null;
								DataBase db = DataBase.getInstance();
								try {
												ps = db.getConnection().prepareStatement(this.u);
												ps.setInt(1, u.getNumProvince());
												ps.setInt(2, u.getNumCanton());
												ps.setInt(3, u.getNumDistrito());
												ps.setString(4, u.getAddress());
												ps.setInt(5, u.getIdUbication());
												if (ps.executeUpdate() > 0) {
																return true;
												}
								} catch (SQLException ex) {
												Logger.getLogger(DAO_Ubication.class.getName()).log(Level.SEVERE, null, ex);
								}
								return false;
				}

				@Override
				public boolean delete(int idUbication) {
								PreparedStatement ps = null;
								DataBase db = DataBase.getInstance();
								try {
												ps = db.getConnection().prepareStatement(this.d);
												ps.setInt(1, idUbication);
												if (ps.executeUpdate() > 0) {
																return true;
												}
								} catch (SQLException ex) {
												Logger.getLogger(DAO_Ubication.class.getName()).log(Level.SEVERE, null, ex);
								}
								return false;
				}

				private void closeCnx(PreparedStatement ps, Statement st, ResultSet rs) throws SQLException {
								if (ps != null) {
												ps.close();
								}
								if (st != null) {
												st.close();
								}
								if (rs != null) {
												rs.close();
								}
				}

				public static void main(String[] args) {
								DAO_Ubication dao = new DAO_Ubication();
								Ubication u = new Ubication(0, 4, 2, 1, "hola bb");
								if (dao.create(u) == true) {
												System.out.println("insertado");
								}
								List<Ubication> r = dao.read();
								r.stream().forEach(valor -> System.out.println(valor.getIdUbication()));
								if (dao.update(new Ubication(2, 4, 2, 2, "direccion actualizada")) == true) {
												System.out.println("actualizado");
												//leer
												r = dao.read();
												r.stream().forEach(valor -> {
																System.out.println(valor.getIdUbication());
																System.out.println(valor.getAddress());
												});
								} else {
												System.out.println("el registro a actualizar no existe");
								}
								if (dao.delete(2) == true) {
												System.out.println("borrado");
												r = dao.read();
												r.stream().forEach(valor -> System.out.println(valor.getIdUbication()));
								} else {
												System.out.println("el id a borrar no existe");
								}
				}
}
