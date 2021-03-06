/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DataAccess.DataBase;
import IDAO.I_Ubication;
import Model.Canton;
import Model.District;
import Model.Province;
import Model.Ubication;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author ADMIN
 */
public class DAO_Ubication implements I_Ubication {

	 private final String c = "insert into ubication values(0,?,?,?,?)";
	 private final String r = "select * from ubication";
	 private final String u = "update ubication set numProvince=?,numCanton=?,numDistrito=?,address=? where idUbication=?";
	 private final String d = "delete from ubication where idUbication=?";
	 private final String dis = "select nomDistrito from ubication where nomProvince=? and nomCanton=?;";
	 private final String can = "select distinct nomCanton from ubication where nomProvince=?;";
	 private final String pro = "select distinct nomProvince from ubication;";

	 @Override
	 public boolean create(Ubication u) {
			PreparedStatement ps = null;
			DataBase db = DataBase.getInstance();
			boolean resp = false;
			try {
				 ps = db.getConnection().prepareStatement(c, Statement.RETURN_GENERATED_KEYS);
				 ps.setString(1, u.getProvince());
				 ps.setString(2, u.getCanton());
				 ps.setString(3, u.getDistrito());
				 ps.setString(4, u.getAddress());
				 if (ps.executeUpdate() > 0) {
						resp = true;
				 }
				 ResultSet rs = ps.getGeneratedKeys();
				 if (rs.next()) {
						u.setIdUbication(rs.getInt(1));
				 } else {
						return false;
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
			return resp;
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
										rs.getString("numProvince"),
										rs.getString("numCanton"),
										rs.getString("numDistrito"),
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
				 ps.setString(1, u.getProvince());
				 ps.setString(2, u.getCanton());
				 ps.setString(3, u.getDistrito());
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

	 @Override
	 public List<District> districts(String province, String canton) {
			List<District> list = new ArrayList<>();
			PreparedStatement ps = null;
			DataBase db = DataBase.getInstance();
			ResultSet rs = null;
			try {
				 ps = db.getConnection().prepareStatement(this.dis);
				 ps.setString(1, province);
				 ps.setString(2, canton);
				 rs = ps.executeQuery();
				 while (rs.next()) {
						list.add(new District(rs.getString(1)));
				 }
			} catch (SQLException ex) {
				 Logger.getLogger(DAO_Ubication.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				 try {
						this.closeCnx(ps, null, rs);
				 } catch (SQLException ex) {
						Logger.getLogger(DAO_Ubication.class.getName()).log(Level.SEVERE, null, ex);
				 }
			}
			return list;
	 }

	 @Override
	 public List<Canton> cantons(String province) {
			List<Canton> list = new ArrayList<>();
			PreparedStatement ps = null;
			DataBase db = DataBase.getInstance();
			ResultSet rs = null;
			try {
				 ps = db.getConnection().prepareStatement(this.can);
				 ps.setString(1, province);
				 rs = ps.executeQuery();
				 while (rs.next()) {
						list.add(new Canton(rs.getString(1), this.districts(province, rs.getString(1))));
				 }
			} catch (SQLException ex) {
				 Logger.getLogger(DAO_Ubication.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				 try {
						this.closeCnx(ps, null, rs);
				 } catch (SQLException ex) {
						Logger.getLogger(DAO_Ubication.class.getName()).log(Level.SEVERE, null, ex);
				 }
			}
			return list;
	 }

	 @Override
	 public List<Province> provinces() {
			List<Province> list = new ArrayList<>();
			Statement st = null;
			DataBase db = DataBase.getInstance();
			ResultSet rs = null;
			try {
				 st = db.getConnection().createStatement();
				 rs = st.executeQuery(this.pro);
				 while (rs.next()) {
						list.add(new Province(rs.getString(1), this.cantons(rs.getString(1))));
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

	 public static void main(String[] args) {
			DAO_Ubication dao = new DAO_Ubication();

			Stream<Province> prov = dao.provinces().stream();
			prov.forEach(System.out::println);

//			Ubication u = new Ubication(0, "heredia", "Barva", "Puente Salas", "hola bb");
//			if (dao.create(u) == true) {
//				 System.out.println("insertado");
//			}
//			List<Ubication> r = dao.read();
//			r.stream().forEach(valor -> System.out.println(valor.getIdUbication()));
//			if (dao.update(new Ubication(2, "heredia", "Barva", "Puente Salas", "direccion actualizada")) == true) {
//				 System.out.println("actualizado");
//				 //leer
//				 r = dao.read();
//				 r.stream().forEach(valor -> {
//						System.out.println(valor.getIdUbication());
//						System.out.println(valor.getAddress());
//				 });
//			} else {
//				 System.out.println("el registro a actualizar no existe");
//			}
//			if (dao.delete(2) == true) {
//				 System.out.println("borrado");
//				 r = dao.read();
//				 r.stream().forEach(valor -> System.out.println(valor.getIdUbication()));
//			} else {
//				 System.out.println("el id a borrar no existe");
//			}
	 }

}
