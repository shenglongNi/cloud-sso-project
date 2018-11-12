
package sso.core.authentication.invoker.spi;

import cloud.sso.domain.User;

public interface IServiceInvoker {

	Long getUserIdByMobile(String mobile);
	
	User getUser(Long userId);
}
