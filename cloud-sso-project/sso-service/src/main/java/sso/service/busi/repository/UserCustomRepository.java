package sso.service.busi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import cloud.sso.domain.UserMobileRelated;
import sso.service.busi.custom.repository.CustomRepository;

public interface UserCustomRepository extends CustomRepository<UserMobileRelated, Long>{


}
