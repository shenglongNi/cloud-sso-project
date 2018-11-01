package cloud.sso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.sso.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUserId(Long userId);
}
