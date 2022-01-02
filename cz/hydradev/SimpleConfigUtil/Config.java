package cz.hydradev.SimpleConfigUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CopyOnWriteArrayList;

import com.google.common.io.Files;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;

public class Config {

	private File configFile;
	private JsonObject confObj = new JsonObject();
	private JsonObject metaObj = new JsonObject();
	private JsonObject configObj = new JsonObject();
	private CopyOnWriteArrayList<ConfigElement> elements = new CopyOnWriteArrayList<ConfigElement>();
	private boolean useMeta = false;
	
	public Config() {
		
	}
	
	public Config(File configFile) {
		this.configFile = configFile;
	}
	
	/*  Metadata  */
	
	/**
	 * Sets config version
	 * @param version - version value
	 */
	public void setConfigVersion(int version) {
		metaObj.addProperty("configVer", version);
	}
	
	/**
	 * Returns config version
	 * @return config version
	 */
	public int getConfigVersion() {
		if (metaObj.has("configVer")) {
			JsonElement verElm = metaObj.get("configVer");
			
			if (verElm != null && verElm.isJsonPrimitive() && ((JsonPrimitive) verElm).isNumber()) {
				return verElm.getAsInt();
			}
		}
		return -1;
	}
	
	/**
	 * Adds string to metadata
	 * @param key - key
	 * @param value - string value
	 */
	public void addStringToMetadata(String key, String value) {
		metaObj.addProperty(key, value);
	}
	
	/**
	 * Returns string from metadata
	 * @param key - key
	 * @return string from metadata
	 */
	public String getStringFromMetadata(String key) {
		if (metaObj.has(key)) {
			JsonElement verElm = metaObj.get(key);
			
			if (verElm != null && verElm.isJsonPrimitive() && ((JsonPrimitive) verElm).isString()) {
				return verElm.getAsString();
			}
		}
		return null;
	}
	
	/**
	 * Adds int to metadata
	 * @param key - key
	 * @param value - int value
	 */
	public void addIntToMetadata(String key, int value) {
		metaObj.addProperty(key, value);
	}
	
	/**
	 * Returns int from metadata
	 * @param key - key
	 * @return int from metadata
	 */
	public int getIntFromMetadata(String key) {
		if (metaObj.has(key)) {
			JsonElement verElm = metaObj.get(key);
			
			if (verElm != null && verElm.isJsonPrimitive() && ((JsonPrimitive) verElm).isNumber()) {
				return verElm.getAsInt();
			}
		}
		return -1;
	}
	
	/**
	 * Adds double to metadata
	 * @param key - key
	 * @param value - double value
	 */
	public void addDoubleToMetadata(String key, double value) {
		metaObj.addProperty(key, value);
	}
	
	/**
	 * Returns double from metadata
	 * @param key - key
	 * @return double from metadata
	 */
	public double getDoubleFromMetadata(String key) {
		if (metaObj.has(key)) {
			JsonElement verElm = metaObj.get(key);
			
			if (verElm != null && verElm.isJsonPrimitive() && ((JsonPrimitive) verElm).isNumber()) {
				return verElm.getAsDouble();
			}
		}
		return -1;
	}
	
	/*  Config  */
	
	/**
	 * Adds boolean to config
	 * @param key - key
	 * @param value - boolean value
	 */
	public void addBooleanToConfig(String key, boolean value) {
		configObj.addProperty(key, value);
	}
	
	/**
	 * Returns boolean from config
	 * @param key - key
	 * @return boolean from config
	 */
	public boolean getBooleanFromConfig(String key) {
		if (confObj.has("config")) {
			JsonElement confElm = confObj.get("config");
			
			if (confElm instanceof JsonObject) {
				JsonObject conf = (JsonObject) confElm;
				
				if(conf.has(key)) {
					JsonElement stringElm = conf.get(key);
					
					if (stringElm != null && stringElm.isJsonPrimitive() && ((JsonPrimitive) stringElm).isBoolean()) {
						return stringElm.getAsBoolean();
					}
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Adds string to config
	 * @param key - key
	 * @param value - string value
	 */
	public void addStringToConfig(String key, String value) {
		configObj.addProperty(key, value);
	}
	
	/**
	 * Returns string from config
	 * @param key - key
	 * @return string from config
	 */
	public String getStringFromConfig(String key) {
		if (confObj.has("config")) {
			JsonElement confElm = confObj.get("config");
			
			if (confElm instanceof JsonObject) {
				JsonObject conf = (JsonObject) confElm;
				
				if(conf.has(key)) {
					JsonElement stringElm = conf.get(key);
					
					if (stringElm != null && stringElm.isJsonPrimitive() && ((JsonPrimitive) stringElm).isString()) {
						return stringElm.getAsString();
					}
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Adds int to config
	 * @param key - key
	 * @param value - int value
	 */
	public void addIntToConfig(String key, int value) {
		configObj.addProperty(key, value);
	}
	
	/**
	 * Returns int from config
	 * @param key - key
	 * @return int from config
	 */
	public int getIntFromConfig(String key) {
		if (confObj.has("config")) {
			JsonElement confElm = confObj.get("config");
			
			if (confElm instanceof JsonObject) {
				JsonObject conf = (JsonObject) confElm;
				
				if(conf.has(key)) {
					JsonElement stringElm = conf.get(key);
					
					if (stringElm != null && stringElm.isJsonPrimitive() && ((JsonPrimitive) stringElm).isNumber()) {
						return stringElm.getAsInt();
					}
				}
			}
		}
		
		return -1;
	}
	
	/**
	 * Adds double to config
	 * @param key - key
	 * @param value - double value
	 */
	public void addDoubleToConfig(String key, double value) {
		configObj.addProperty(key, value);
	}
	
	/**
	 * Returns double from config
	 * @param key - key
	 * @return double from config
	 */
	public double getDoubleFromConfig(String key) {
		if (confObj.has("config")) {
			JsonElement confElm = confObj.get("config");
			
			if (confElm instanceof JsonObject) {
				JsonObject conf = (JsonObject) confElm;
				
				if(conf.has(key)) {
					JsonElement stringElm = conf.get(key);
					
					if (stringElm != null && stringElm.isJsonPrimitive() && ((JsonPrimitive) stringElm).isNumber()) {
						return stringElm.getAsDouble();
					}
				}
			}
		}
		
		return -1;
	}
	
	/*  Element  */
	
	/**
	 * Adds element to config
	 * @param element - element
	 */
	public void addElementToConfig(ConfigElement element) {
		elements.add(element);
	}
	
	/**
	 * Returns boolean from element
	 * @param element - element
	 * @param key - key
	 * @return boolean from element
	 */
	public boolean getBooleanFromElement(ConfigElement element, String key) {
		if (confObj.has(element.getName())) {
			JsonElement confElm = confObj.get(element.getName());
			
			if (confElm instanceof JsonObject) {
				JsonObject conf = (JsonObject) confElm;
				
				if(conf.has(key)) {
					JsonElement stringElm = conf.get(key);
					
					if (stringElm != null && stringElm.isJsonPrimitive() && ((JsonPrimitive) stringElm).isBoolean()) {
						return stringElm.getAsBoolean();
					}
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Returns boolean from element
	 * @param elementName - name of element
	 * @param key - key
	 * @return - boolean from element
	 */
	public boolean getBooleanFromElement(String elementName, String key) {
		if (confObj.has(elementName)) {
			JsonElement confElm = confObj.get(elementName);
			
			if (confElm instanceof JsonObject) {
				JsonObject conf = (JsonObject) confElm;
				
				if(conf.has(key)) {
					JsonElement stringElm = conf.get(key);
					
					if (stringElm != null && stringElm.isJsonPrimitive() && ((JsonPrimitive) stringElm).isBoolean()) {
						return stringElm.getAsBoolean();
					}
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Returns string from element
	 * @param element - element
	 * @param key - key
	 * @return string from element
	 */
	public String getStringFromElement(ConfigElement element, String key) {
		if (confObj.has(element.getName())) {
			JsonElement confElm = confObj.get(element.getName());
			
			if (confElm instanceof JsonObject) {
				JsonObject conf = (JsonObject) confElm;
				
				if(conf.has(key)) {
					JsonElement stringElm = conf.get(key);
					
					if (stringElm != null && stringElm.isJsonPrimitive() && ((JsonPrimitive) stringElm).isString()) {
						return stringElm.getAsString();
					}
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Returns string from element
	 * @param elementName - name of element
	 * @param key - key
	 * @return - string from element
	 */
	public String getStringFromElement(String elementName, String key) {
		if (confObj.has(elementName)) {
			JsonElement confElm = confObj.get(elementName);
			
			if (confElm instanceof JsonObject) {
				JsonObject conf = (JsonObject) confElm;
				
				if(conf.has(key)) {
					JsonElement stringElm = conf.get(key);
					
					if (stringElm != null && stringElm.isJsonPrimitive() && ((JsonPrimitive) stringElm).isString()) {
						return stringElm.getAsString();
					}
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Returns int from element
	 * @param element - element
	 * @param key - key
	 * @return int from element
	 */
	public int getIntFromElement(ConfigElement element, String key) {
		if (confObj.has(element.getName())) {
			JsonElement confElm = confObj.get(element.getName());
			
			if (confElm instanceof JsonObject) {
				JsonObject conf = (JsonObject) confElm;
				
				if(conf.has(key)) {
					JsonElement stringElm = conf.get(key);
					
					if (stringElm != null && stringElm.isJsonPrimitive() && ((JsonPrimitive) stringElm).isNumber()) {
						return stringElm.getAsInt();
					}
				}
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns int from element
	 * @param elementName - name of element
	 * @param key - key
	 * @return - int from element
	 */
	public int getIntFromElement(String elementName, String key) {
		if (confObj.has(elementName)) {
			JsonElement confElm = confObj.get(elementName);
			
			if (confElm instanceof JsonObject) {
				JsonObject conf = (JsonObject) confElm;
				
				if(conf.has(key)) {
					JsonElement stringElm = conf.get(key);
					
					if (stringElm != null && stringElm.isJsonPrimitive() && ((JsonPrimitive) stringElm).isNumber()) {
						return stringElm.getAsInt();
					}
				}
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns double from element
	 * @param element - element
	 * @param key - key
	 * @return double from element
	 */
	public double getDoubleFromElement(ConfigElement element, String key) {
		if (confObj.has(element.getName())) {
			JsonElement confElm = confObj.get(element.getName());
			
			if (confElm instanceof JsonObject) {
				JsonObject conf = (JsonObject) confElm;
				
				if(conf.has(key)) {
					JsonElement stringElm = conf.get(key);
					
					if (stringElm != null && stringElm.isJsonPrimitive() && ((JsonPrimitive) stringElm).isNumber()) {
						return stringElm.getAsDouble();
					}
				}
			}
		}
		
		return -1;
	}
	
	/**
	 * Returns double from element
	 * @param elementName - name of element
	 * @param key - key
	 * @return - double from element
	 */
	public double getDoubleFromElement(String elementName, String key) {
		if (confObj.has(elementName)) {
			JsonElement confElm = confObj.get(elementName);
			
			if (confElm instanceof JsonObject) {
				JsonObject conf = (JsonObject) confElm;
				
				if(conf.has(key)) {
					JsonElement stringElm = conf.get(key);
					
					if (stringElm != null && stringElm.isJsonPrimitive() && ((JsonPrimitive) stringElm).isNumber()) {
						return stringElm.getAsDouble();
					}
				}
			}
		}
		
		return -1;
	}
	
	/*  Other  */
	
	/**
	 * Returns config file
	 * @return config file
	 */
	public File getConfigFile() {
		return configFile;
	}

	/**
	 * Sets config file
	 * @param configFile - config file
	 */
	public void setConfigFile(File configFile) {
		this.configFile = configFile;
	}

	/**
	 * Saves config
	 */
	public void saveConfig() {
		try {
			confObj.add("metadata", metaObj);
			confObj.add("config", configObj);
			
			for(ConfigElement element : elements) {
				confObj.add(element.getName(), element.getConfObj());
			}
			
			Files.write(confObj.toString().getBytes(StandardCharsets.UTF_8), this.configFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads config
	 * @throws JsonIOException
	 * @throws JsonSyntaxException
	 * @throws FileNotFoundException
	 */
	public void loadConfig() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		this.confObj = (JsonObject) new JsonParser().parse(new InputStreamReader(new FileInputStream(this.configFile)));
		
		if (confObj.has("metadata")) {
			JsonElement confElm = confObj.get("metadata");
			
			if (confElm instanceof JsonObject) {
				JsonObject conf = (JsonObject) confElm;
				
				metaObj = conf;
			}
		}
	}
}