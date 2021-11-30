package com.r17a.jndi.rmi;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 服务器端实现远程接口。
 * 必须继承UnicastRemoteObject，以允许JVM创建远程的存根/代理。
 */
public class Calc extends UnicastRemoteObject implements ICalc {

    public Calc() throws RemoteException {
    }


    public void calc() throws IOException {
        Runtime.getRuntime().exec("calc");
    }
}
