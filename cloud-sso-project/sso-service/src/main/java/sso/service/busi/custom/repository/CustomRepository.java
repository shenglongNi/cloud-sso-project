package sso.service.busi.custom.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomRepository<T, ID extends Serializable>  extends JpaRepository<T, ID>{

	public String customFind(ID id);
	
}
