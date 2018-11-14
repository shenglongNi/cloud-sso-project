package sso.service.busi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sso.service.busi.repository.UserCustomRepository;
import sso.service.busi.service.spi.ICustomService;

@Service
public class CustomService implements ICustomService {
	
	@Autowired
	private UserCustomRepository userCustomRepository;
	
	
	@Override
	public String getString(Long id) {
		return userCustomRepository.customFind(id);
	}

	
}
                                                        