package sso.service.busi.custom.repofactory;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;

import sso.service.busi.custom.repository.CustomRepositoryImpl;

public class CustomRepositoryFactory<T, ID extends Serializable> extends JpaRepositoryFactory {


	public CustomRepositoryFactory(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(
			RepositoryInformation information, EntityManager entityManager) {

		return new CustomRepositoryImpl<T, ID>((Class<T>) information.getDomainType(), entityManager);
	}

	@Override
	protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {

		return CustomRepositoryImpl.class;
	}
}
