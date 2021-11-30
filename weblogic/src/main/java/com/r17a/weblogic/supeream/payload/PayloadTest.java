package com.r17a.weblogic.supeream.payload;

import com.r17a.weblogic.supeream.serial.BytesOperation;

/**
 * Created by nike on 17/7/3.
 */
public class PayloadTest {
    public static void main(String[] args) throws Exception {
//        byte[] iRemoteCode = BytesOperation.GetByteByFile("/Users/nike/IdeaProjects/weblogic_cmd/out/production/weblogic_cmd/com/com.supeream/payload/IRemote.class");
//        System.out.println(BytesOperation.bytesToHexString(iRemoteCode));
        //DefiningClassLoader definingClassLoader = new DefiningClassLoader();
//        Class<?> cls = definingClassLoader.defineClass("com.com.supeream.payload.IRemote",iRemoteCode);
        byte[] remoteCodeImpl = BytesOperation.GetByteByFile("/Users/nike/IdeaProjects/weblogic_cmd/out/production/weblogic_cmd/com/com.supeream/payload/RemoteImpl.class");
        System.out.println(BytesOperation.bytesToHexString(remoteCodeImpl));

//        Class<?> cls_ = definingClassLoader.defineClass("com.com.supeream.payload.RemoteImpl", remoteCodeImpl);
        Class.forName("com.supeream.payload.RemoteImpl");
//        System.out.println(cls_);
    }
}
