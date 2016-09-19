package com.base.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Config from application.yaml
 */
@Component
@ConfigurationProperties(prefix="configObject")
public class ConfigObject {
    private String name;
    private String value;

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "ConfigObject{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
