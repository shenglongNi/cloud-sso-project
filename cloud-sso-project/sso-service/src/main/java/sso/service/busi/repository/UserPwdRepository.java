package sso.service.busi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.sso.domain.UserPwdInfo;

public interface UserPwdRepository extends JpaRepository<UserPwdInfo, Long>{
	
	UserPwdInfo findUserPwdByUserId(Long userId);
}
