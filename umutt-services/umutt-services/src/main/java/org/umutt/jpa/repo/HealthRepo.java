package org.umutt.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.umutt.jpa.model.Health;

@Repository
public interface HealthRepo extends JpaRepository<Health, String> {

}
