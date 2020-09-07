
package DAO;

import DataAccess.DataBase;
import IDAO.I_Product;
import Model.Product;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class DAO_Product implements I_Product {

				private final String c = "insert into eif209_2020_p01.product values(0,?,?,?,?)";
				private final String r = "";
				private final String u = "";
				private final String d = "";

				@Override
				public boolean create(Product p, String owner) {
								DataBase bd = DataBase.getInstance();
								try {
												PreparedStatement ps = bd.getConnection().prepareStatement(this.c);
												ps.setString(1, p.getDetail());
												ps.setFloat(2, p.getPrice());
												ps.setFloat(3, p.getIva());
												ps.setString(4, owner);
												if (ps.executeUpdate() > 0) {
																return true;
												}
								} catch (SQLException ex) {
												Logger.getLogger(DAO_Product.class.getName()).log(Level.SEVERE, null, ex);
								}
								return false;
				}

				@Override
				public List<Product> read(String owner) {
								return null;
				}

				@Override
				public boolean update(Product p, String owner) {
								return false;
				}

				@Override
				public Optional<Product> delete(String id, String owner) {
								return null;
				}

}
