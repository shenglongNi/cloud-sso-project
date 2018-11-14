package sso.service.busi.repository;

import cloud.sso.domain.User;
import sso.service.busi.custom.repository.CustomRepository;

public interface UserRepository extends CustomRepository<User, Long>{
	
	User findByUserId(Long userId);
}
