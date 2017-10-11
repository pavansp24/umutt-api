package org.umutt.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.umutt.jpa.model.Registrations;

@Repository
public interface RegistrationsRepo extends JpaRepository<Registrations, Long> {

	@Query(value="select registration from Registrations registration where registration.createdBy=?1")
	List<Registrations> findByVolunteer(String userId);
}
