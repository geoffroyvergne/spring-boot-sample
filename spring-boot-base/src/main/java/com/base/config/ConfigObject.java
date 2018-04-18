package com.base.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// @Component
@ConfigurationProperties(prefix="configobject")
public class ConfigObject {
    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ConfigObject{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
