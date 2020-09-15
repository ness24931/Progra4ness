/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import IDAO.I_Personal_Info;
import Model.Person;

/**
 *
 * @author ADMIN
 */
public class DAO_Personal_Info implements I_Personal_Info {

	 private String create = "insert into personal_info values(?,?,?,?,?,?,?,?);";
	 private String search = "select * from personal_info where dni=?;";
	 private String update = "update personal_info set name = ?, telephone =?, e-mail =?, tradename =?, location int \n" +
"id_type int \n" +
"user ?,?,?,?,?,?,?,?);";

	 @Override
	 public boolean create(Person p) {
			throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

}
