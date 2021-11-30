package com.r17a.jndi.rmi;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RmiClient {
    public static void main(String[] args) {
        try {
            /***********方法1***************************/
            // 如果RMI Registry就在本地机器上，URL就是:rmi://localhost:1099/hello
            // 否则，URL就是：rmi://RMIService_IP:1099/hello
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",1999);
            // 从Registry中检索远程对象的存根/代理
            // 查找名为calculate的服务，这里必须是Icalc不能是Calc
            ICalc calculate = (ICalc) registry.lookup("calculate");
            /***********方法2***************************/
//            Icalc calculate = (Icalc) Naming.lookup("rmi://localhost:1999/calculate");
            // 调用远程对象的方法
            calculate.calc();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
