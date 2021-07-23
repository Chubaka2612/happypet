package com.epam.sdet.happypet.core.properties;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * {@code Props} class provides ability for getting of properties from different .properties files.
 *
 */
public class Props {

    private static final String BASE_PROP_DIR = "properties";
    private static final String ENV_PROP_DIR = "properties/env";
    private static final String BASE_CONFIG_FILE = "BASE";
    private static final String FILE_EXTENSION = ".properties";

    private static Props instance;
    private static Map<String, Properties> props;

    private Props() {
        props = new HashMap<>();
    }

    /**
     * <em>Merging of properties</em>
     * @param envName - the name of environment
     * @param properties - corresponding properties.
     */
    private void mergeProperties(String envName, Properties properties) {
        if(props.get(envName) == null) {
            props.put(envName, properties);
        } else {
            for (Map.Entry<Object, Object> entry: properties.entrySet()) {
                props.get(envName).put(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * <em>Getting instance of Props class</em>
     * @return Props - a single Props instance.
     */
    public static Props getInstance() {
        try {
            if (instance == null) {
                throw new Exception("Properties were not initialized");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    /**
     * <em>Initializing of Props instance</em>
     * @param envName - the name of environment.
     */
    public static synchronized void init(String envName) {
        if (instance == null) {
            instance = new Props();
        }
        instance.initEnvProps(envName);
    }

    /**
     * <em>Getting string type property by given key</em>
     * @param key - property name
     * @return String - string value of property.
     */
    public String getString(String key) {
        try {
            if (props.size() > 1) {
                throw new Exception("Properties are defined for more than one environment. " +
                        "Please, use overloaded getString(String key, String envName) method.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getString(key, props.keySet().toArray()[0].toString());
    }

    /**
     * <em>Getting string type property for specified environment</em>
     * @param key - property name
     * @param envName - the name of environment
     * @return String - string value of property.
     */
    public String getString(String key, String envName) {
        if (envName == null) {
            return getString(key);
        }
        return props.get(envName).getProperty(key);
    }

    /**
     * <em>Getting boolean type property by given key</em>
     * @param key - property name
     * @return boolean - boolean type property.
     */
    public boolean getBoolean(String key) {
        return Boolean.parseBoolean(getString(key));
    }

    /**
     * <em>Getting boolean type property for specified environment</em>
     * @param key - property name
     * @param envName - the name of environment
     * @return boolean - boolean type property.
     */
    public boolean getBoolean(String key, String envName) {
        return Boolean.parseBoolean(getString(key, envName));
    }

    /**
     * <em>Getting integer type property by given key</em>
     * @param key - property name
     * @return int - integer type property.
     */
    public int getInt(String key) {
        return Integer.parseInt(getString(key));
    }

    /**
     * <em>Getting integer type property for specified environment</em>
     * @param key - property name
     * @param envName - the name of environment
     * @return int - integer type property.
     */
    public int getInt(String key, String envName) {
        return Integer.parseInt(getString(key, envName));
    }

    /**
     * <em>Initializing environment properties</em>
     * @param envName - the name of environment.
     */
    private void initEnvProps(String envName) {
        Properties baseProperties = new Properties();
        Properties envProperties = new Properties();
        try {
            baseProperties.load(this.getClass().getClassLoader().getResourceAsStream(Paths
                    .get(BASE_PROP_DIR, BASE_CONFIG_FILE + FILE_EXTENSION).toString()));
            envProperties.load(this.getClass().getClassLoader().getResourceAsStream(Paths
                    .get(ENV_PROP_DIR, envName + FILE_EXTENSION).toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        mergeProperties(envName, baseProperties);
        mergeProperties(envName, envProperties);
    }
}