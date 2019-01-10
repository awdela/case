package com.test.properties;

import java.util.Properties;

public class PropertyTest {

    public static void main(String[] args) {
        Properties prop = new Properties();
        StringBuilder sb = new StringBuilder();
        sb.append("com.caimi.service.repository.entity,");
        sb.append("com.caimi.service.repository.entity.cache,");
        sb.append("com.caimi.service.repository.entity.accessor");
        prop.setProperty("packages", sb.toString());
        System.out.println(prop.toString());
    }

}
