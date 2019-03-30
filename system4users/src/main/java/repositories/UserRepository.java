package repositories;

import domain.User;

public interface UserRepository {
	
	User getUserByName (String name);
	void add (User user);
	int count();

}
