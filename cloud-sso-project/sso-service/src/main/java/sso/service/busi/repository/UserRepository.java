package sso.service.busi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.sso.domain.User;

public interface UserRepository {
	
	User findByUserId(Long userId);
}
