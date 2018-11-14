package sso.service.busi.custom.repofactory;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class CustomRepositoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable> extends JpaRepositoryFactoryBean<T, S, ID>{
	
	private EntityManager entityManager;
	
	public CustomRepositoryBean(Class<? extends T> repositoryInterface) {
		super(repositoryInterface);
		this.entityManager = entityManager;
	}
	
	
	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		
		return new CustomRepositoryFactory(entityManager);
	}
	
	
}
