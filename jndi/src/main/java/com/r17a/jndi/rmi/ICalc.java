package com.r17a.jndi.rmi;

import java.io.IOException;
import java.rmi.Remote;

/**
 * 必须继承Remote接口。
 * 所有参数和返回类型必须序列化(因为要网络传输)。
 * 任意远程对象都必须实现此接口。
 * 只有远程接口中指定的方法可以被调用。
 */
public interface ICalc extends Remote {
    void calc() throws IOException;
}
