
package sso.service.busi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.sso.domain.User;
import cloud.sso.domain.UserMobileRelated;


public interface UserMobileRelatedRepository extends JpaRepository<UserMobileRelated, Long>{

	UserMobileRelated findByMobile(String mobile);
	
}

