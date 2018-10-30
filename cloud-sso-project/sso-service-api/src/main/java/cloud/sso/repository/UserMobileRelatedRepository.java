package cloud.sso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cloud.sso.domain.UserMobileRelated;

public interface UserMobileRelatedRepository extends JpaRepository<UserMobileRelated, Long>{

	UserMobileRelated findByMobile(String mobile);
}
