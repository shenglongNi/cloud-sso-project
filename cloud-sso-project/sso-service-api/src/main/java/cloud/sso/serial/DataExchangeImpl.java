package cloud.sso.serial;

import cloud.sso.api.DataExchange;

import com.alibaba.fastjson.JSONObject;

public class DataExchangeImpl implements DataExchange{
	
	@Override
	public Object jsonDserial(String jsonString) {
		return JSONObject.parseObject(jsonString);
	}

	@Override
	public String jsonSerial(Object obj) {
		return JSONObject.toJSONString(obj);
	}

}
