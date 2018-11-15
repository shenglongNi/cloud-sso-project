package cloud.sso.domain;

import java.util.Map;

import com.google.common.collect.Maps;

public class ResultData {
	
	private String returnCode;
	
	private String returnMsg;
	
	private Map<String, Object> data = Maps.newHashMap();

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultData [returnCode=" + returnCode + ", returnMsg="
				+ returnMsg + ", data=" + data + "]";
	}
	
}
