package client.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;

public class CustCasFilter extends CasFilter{

	private String successPrefix;
	
	
	@Override
	protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
		
		SavedRequest savedRequest = WebUtils.getSavedRequest(request);
		
		String targetUrl = null;
		if(savedRequest != null && "GET".equalsIgnoreCase(savedRequest.getMethod())) {
			targetUrl = successPrefix + savedRequest.getRequestURI();
			if(StringUtils.isNotBlank(savedRequest.getQueryString())) {
				targetUrl = targetUrl + "?" + savedRequest.getQueryString();			}
		}
	}

	
	public void setSuccessPrefix(String successPrefix) {
		this.successPrefix = successPrefix;
	}
	
}
