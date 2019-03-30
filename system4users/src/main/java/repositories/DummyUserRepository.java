package repositories;

import java.util.ArrayList;
import java.util.List;

import domain.User;

public class DummyUserRepository implements UserRepository {
	
	private static List<User> db = new ArrayList<User>();

	@Override
	public User getUserByName(String name) {
		for(User user: db) {
			if(user.getName().equals(name))
				return user;
		}
		return null;
	}

	@Override
	public void add(User user) {
		db.add(user);
	}

	@Override
	public int count() {
		return db.size();
	}

}
