package sso.service.busi.custom.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;


@NoRepositoryBean
public interface CustomRepository<T, ID extends Serializable>  extends PagingAndSortingRepository<T, ID>{

	public String customFind(ID id);
	
}
