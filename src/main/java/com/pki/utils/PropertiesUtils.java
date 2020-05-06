package com.pki.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @author by twjitm on 2018/12/21/17:59
 */
public class PropertiesUtils {
    private static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);
    private static String keytool;
    private static String bookPath;
    private static int osType = 0;
    private static String libraryPsd;

    public PropertiesUtils() {
        init();
    }
    public void init() {
        Properties properties = new Properties();
        try {
            logger.info("init system properties file begin");
            properties.load(this.getClass().getClassLoader().getResourceAsStream("spring/system.properties"));
            keytool = properties.getProperty("keytool");
            bookPath = properties.getProperty("bookPath");
            libraryPsd = properties.getProperty("libraryPsd");
            osType = Integer.parseInt(properties.getProperty("ongoing_operation"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getKeytool() {
        return keytool;
    }

    public static String getBookPath() {
        return bookPath;
    }

    public static int getOsType() {
        return osType;
    }

    public static String getLibraryPsd() {
        return libraryPsd;
    }
}
