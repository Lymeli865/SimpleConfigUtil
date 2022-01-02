package cz.hydradev.SimpleConfigUtil;

import com.google.gson.JsonObject;

public class ConfigElement {

	private String name;
	private JsonObject confObj = new JsonObject();
	
	public ConfigElement(String elementName) {
		name = elementName;
	}

	public void addBooleanToElement(String key, boolean value) {
		confObj.addProperty(key, value);
	}
	
	public void addStringToElement(String key, String value) {
		confObj.addProperty(key, value);
	}
	
	public void addIntToElement(String key, int value) {
		confObj.addProperty(key, value);
	}
	
	public void addDoubleToElement(String key, double value) {
		confObj.addProperty(key, value);
	}
	
	public String getName() {
		return name;
	}
	
	public JsonObject getConfObj() {
		return confObj;
	}
}