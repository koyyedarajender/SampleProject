package com.integrum.application.utills;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigFile {

  //Below variables are framework level
  public static String userName;
  public static String password;
  public static String instanceName;
  public static String applicationUrl;
  public static String browserName;
  public static String projectDirectory;
  public static String headless;
  public static Map<String, String> propertiesAsMap;
  public static String scenarioID;

  //Below variables are functional
  public static String fieldCategoryName;
  public static String fieldName;
  public static String fieldID;
  public static String sectionCategoryName;
  public static String sectionTitleName;
  public static String sectionID;
  public static String formTemplateCategoryName;
  public static String formTemplateTitleName;
  public static String formTemplateID;
  public static String viewTitleName;
  public static String viewID;



  public static void setupConfiguration() {
    projectDirectory = System.getProperty("user.dir");
    propertiesAsMap = new HashMap<>();
    loadEnvProperties();
    loadConfigEnvProperties();
    setApplicationurl();
    setConfigPropertiesValues();
    setBrowser();
  }



  public static void setConfigPropertiesValues() {
    userName = propertiesAsMap.get(instanceName + "_userName");
    System.out.println("Provided userName value is : " + userName);
    password = propertiesAsMap.get(instanceName + "_password");
    System.out.println("Provided password value is : " + password);

    fieldCategoryName = propertiesAsMap.get(instanceName + "_fieldCategoryName");
    System.out.println("Provided fieldCategoryName value is : " + fieldCategoryName);
    sectionCategoryName = propertiesAsMap.get(instanceName + "_sectionCategoryName");
    System.out.println("Provided sectionCategoryName value is : " + sectionCategoryName);
    formTemplateCategoryName = propertiesAsMap.get(instanceName + "_formTemplateCategoryName");
    System.out.println("Provided formTemplateCategoryName value is : " + formTemplateCategoryName);

  }

  public static void loadEnvProperties() {
    Properties readProperties = new Properties();
    try {
      readProperties.load(new FileInputStream(projectDirectory + "/src/test/resources/com.integrum/application/config/env.properties"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    propertiesAsMap.putAll(convertPropertiesIntoMap(readProperties));
  }

  public static void loadConfigEnvProperties() {
    Properties readProperties = new Properties();
    try {
      readProperties.loadFromXML(new FileInputStream(projectDirectory + "/src/test/resources/com.integrum/application/config/config.xml"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    propertiesAsMap.putAll(convertPropertiesIntoMap(readProperties));
    propertiesAsMap.putAll(readSystemProperties());
  }

  public static Map<String, String> readSystemProperties() {
    Properties properties = System.getProperties();
    return convertPropertiesIntoMap(properties);
  }

  public static Map<String, String> convertPropertiesIntoMap(Properties properties) {
    Map<String, String> map = new HashMap<String, String>();
    for (String key : properties.stringPropertyNames()) {
      map.put(key, properties.getProperty(key));
    }
    return map;
  }

  public static void setApplicationurl() {
    instanceName = propertiesAsMap.get("instanceName");
    System.out.println("Provided instanceName value is : " + instanceName);
    applicationUrl = propertiesAsMap.get(instanceName + "_URL");
    System.out.println("Provided instanceName url value is : " + applicationUrl);

  }

  public static void setBrowser() {
    browserName = propertiesAsMap.get("browser");
    headless = propertiesAsMap.get("headless");
  }
}
