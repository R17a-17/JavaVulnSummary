package com.r17a.jndi.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 注册远程对象,向客户端提供远程对象服务。
 * 远程对象是在远程服务上创建的，你无法确切地知道远程服务器上的对象的名称，
 * 但是,将远程对象注册到RMI Registry之后,
 * 客户端就可以通过RMI Registry请求到该远程服务对象的stub，
 * 利用stub代理就可以访问远程服务对象了。
 */
public class RmiRegisterServer{
    private RmiRegisterServer(String port) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(Integer.parseInt(port));
        try {
            registry.bind("calculate",new Calc());
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            String port = "1099";
            new RmiRegisterServer(port);
            System.out.println("RMI服务启动成功...\n");
            System.out.println("Listening on localhost:"+ port +"...");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}