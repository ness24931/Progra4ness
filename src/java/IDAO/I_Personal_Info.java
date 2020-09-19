package IDAO;

import Model.Person;

public interface I_Personal_Info {

	 public boolean create(Person p);

	 public Person search(String id);

	 public Person searchUser(String user);

	 public boolean update(Person p);

	 public boolean delete(String id);

}
