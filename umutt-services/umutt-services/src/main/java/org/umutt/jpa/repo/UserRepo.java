package org.umutt.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.umutt.jpa.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

	@Query(value="select user from User user where user.userId=?1 and user.password=?2")
	public User getUser(String userId , String password);
}
