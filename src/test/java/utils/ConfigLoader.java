package utils;

import constants.EnvType;

import java.util.Properties;

public class ConfigLoader {
    private Properties properties;
    private static ConfigLoader configLoader;

    /***
     * Loads the configuration properties based on the Env System Property sent through Maven command
     */
    private ConfigLoader(){
        //Default Environment
        String env = System.getProperty("env", String.valueOf(EnvType.STAGE));

        //Based on the env parameter of maven command
        switch (EnvType.valueOf(env)){
            case PROD:
                properties = PropertyUtils.PropertyLoader("src/test/resources/configs/prod_config.properties");
                break;
            case STAGE:
                properties = PropertyUtils.PropertyLoader("src/test/resources/configs/stage_config.properties");
                break;
            case TEST:
                System.out.println("TEST Environment - Pending Implementation");
                break;
            default:
                throw new IllegalStateException("INVALID Environment " + env);
        }
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop !=null) return prop;
        else throw new RuntimeException("Properties baseUrl is not specified in the config.properties file");
    }

    public String getBaseUrlApi(){
        String prop = properties.getProperty("baseUrlApi");
        if(prop !=null) return prop;
        else throw new RuntimeException("Properties baseUrlApi is not specified in the config.properties file");
    }
}
