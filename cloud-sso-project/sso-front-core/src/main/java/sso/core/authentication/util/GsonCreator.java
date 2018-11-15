package sso.core.authentication.util;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class GsonCreator {

	
	private static Gson gsonInstance = new GsonBuilder()
		.registerTypeAdapter(Date.class, new DataAdapter())
		.create();

	
	public static Gson createGsonInstance() {
		return gsonInstance;
	}
	
	static class DataAdapter implements JsonDeserializer<Date> {

		@Override
		public Date deserialize(JsonElement ele, Type type,
				JsonDeserializationContext context) throws JsonParseException {
			
			if(StringUtils.isNotBlank(ele.getAsString())) {
				return new Date(ele.getAsLong());
			}
			
			return null;
		}
		
	}
	
}
