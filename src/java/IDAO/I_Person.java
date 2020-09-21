package IDAO;

import Model.List.List_Clients;
import Model.Person;

public interface I_Person {

	 public boolean create(Person p, String owner);

	 public Person search(String id);

	 public List_Clients searchClients(String owner);

	 public boolean update(Person p);

	 public boolean delete(String id);

}
