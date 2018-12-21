package com.pki.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @author by twjitm on 2018/12/21/17:59
 */
public class PropertiesUtils {
    private static Logger logger= LoggerFactory.getLogger(PropertiesUtils.class);
private String keytool;
private String bookPath;

    public void init() {
        Properties properties=new Properties();
        try {
            logger.info("init system properties file begin");
            properties.load(this.getClass().getClassLoader().getResourceAsStream("spring/system.properties"));
            keytool=properties.getProperty("keytool");
            bookPath=properties.getProperty("bookPath");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getKeytool() {
        return keytool;
    }

    public String getBookPath() {
        return bookPath;
    }
}
