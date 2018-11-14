package sso.service.busi.custom.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CustomRepository<T, ID>{
	
	private final EntityManager entityManager;
	
	
	public CustomRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		 super(domainClass, entityManager);
	        this.entityManager = entityManager;
		
	}
	
	public CustomRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public String customFind(ID id) {
		
		return "1111";
	}

}
