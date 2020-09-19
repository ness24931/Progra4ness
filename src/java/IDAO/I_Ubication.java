/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import Model.Canton;
import Model.District;
import Model.Province;
import Model.Ubication;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ADMIN
 */
public interface I_Ubication {

	 public boolean create(Ubication u);

	 public List<Ubication> read();

	 public boolean update(Ubication u);

	 public boolean delete(int idUbication);

	 public List<District> districts(String province, String canton);

	 public List<Canton> cantons(String province);

	 public List<Province> provinces();

}
