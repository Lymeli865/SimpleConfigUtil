package cz.hydradev.SimpleConfigUtil;

import java.io.File;
import java.io.FileNotFoundException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class MainExample {

	public static void main(String[] args) {
		File file = new File("config.json");
		
		/*
		 * Save config
		 */
		
		Config a = new Config(file);
		ConfigElement el = new ConfigElement("Element");
		el.addStringToElement("string", "hmmmm");
		el.addBooleanToElement("bool", true);
		el.addDoubleToElement("double", 0.9);
		el.addIntToElement("int", 55);
		
		a.setConfigVersion(1);
		a.addStringToConfig("key0", "val");
		a.addBooleanToConfig("key1", false);
		a.addIntToConfig("key2", 13);
		a.addDoubleToConfig("key3", 0.3);
		a.addElementToConfig(el);
		a.saveConfig();
		System.out.println("saved!");
		
		/*
		 * Load config
		 */
		
		Config b = new Config(file);
		try {
			b.loadConfig();
			System.out.println("loaded!");
			
			int ver = b.getConfigVersion();
			
			String val = b.getStringFromConfig("key0");
			boolean boole = b.getBooleanFromConfig("key1");
			int intt = b.getIntFromConfig("key2");
			double doublee = b.getDoubleFromConfig("key3");
			
			String elString = b.getStringFromElement(el, "string");
			boolean bool = b.getBooleanFromElement(el, "bool");
			int inttt = b.getIntFromElement(el, "int");
			double doubleee = b.getDoubleFromElement(el, "double");
			System.out.println("configVer=" + ver);
			System.out.println("key0=" + val);
			System.out.println("key1=" + boole);
			System.out.println("key2=" + intt);
			System.out.println("key3=" + doublee);
			System.out.println("elementString=" + elString);
			System.out.println("elementBool=" + bool);
			System.out.println("elementInt=" + inttt);
			System.out.println("elementDouble=" + doubleee);
		} catch (JsonIOException e) {
			System.out.println("error has occured: ");
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			System.out.println("error has occured: ");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("error has occured: ");
			e.printStackTrace();
		}
	}

}
