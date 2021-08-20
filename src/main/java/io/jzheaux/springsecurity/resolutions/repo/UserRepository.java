package io.jzheaux.springsecurity.resolutions.repo;

import io.jzheaux.springsecurity.resolutions.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
	Optional<User> findByUsername(String username);
}
