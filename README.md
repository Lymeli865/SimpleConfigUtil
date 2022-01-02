# SimpleConfigUtil
Simple config util for java

How to use:
```java
//Initializates variable
//new File("config.json") is location of config
Config config = new Config(new File("config.json"));

//------------------------
//-- How to save config --
//------------------------

//Sets config version
//1 is config version
config.setConfigVersion(1);

//Adds string to config
//key0 is key, string is value
config.addStringToConfig("key0", "string");

//Adds int to config
//key1 is key, 28 is value
config.addIntToConfig("key1", 28);

//Adds double to config
//key2 is key, 0.5 is value
config.addDoubleToConfig("key2", 0.5);

//Adds boolean to config
//key3 is key, true is value
config.addBooleanToConfig("key3", true);

//Initializates element
//Element is element name
ConfigElement element = new ConfigElement("Element");

//Adds string to element
element.addStringToElement("string", "stringFromElement");

//Adds boolean to element
element.addBooleanToElement("bool", false);

//Adds double to element
element.addDoubleToElement("double", 0.9);

//Adds int to element
element.addIntToElement("int", 55);

//Adds element to config
config.addElementToConfig(element);

//Saves config
config.saveConfig();

//------------------------
//-- How to load config --
//------------------------

//Loads config
config.loadConfig();

//Returns string from config
b.getStringFromConfig("key0");

//Returns int from config
b.getIntFromConfig("key1");

//Returns double from config
b.getDoubleFromConfig("key2");

//Returns boolean from config
b.getBooleanFromConfig("key3");

//Returns config version
b.getConfigVersion();

//Element in config
ConfigElement element = new ConfigElement("Element");

//Returns string from element in config
b.getStringFromElement(element, "string");

//Returns boolean from element in config
b.getBooleanFromElement(element, "bool");

//Returns int from element in config
b.getIntFromElement(element, "int");

//Returns double from element in config
b.getDoubleFromElement(element, "double");

```
