package com.r17a.ysoserial.jdk7u21;

public class HashBruteTest {
    public static void main(String[] args) {
//        System.out.println(Long.toHexString(4276154445L).hashCode());
//        for (long i = 0; i < 9999999999L; i++) {
//            if (Long.toHexString(i).hashCode() == 15) {
//                System.out.println(Long.toHexString(i));
//            }
//        }
        caculate();
//         int x=114;
//
//        x ^= (x >>> 20) ^ (x>>> 12);
//        System.out.println( x ^ (x >>> 7) ^ (x >>> 4));
//        System.out.println("---------------------");
//        System.out.println(intHash(new int[]{-16}));

    }

    public static void caculate() {

        for (int i = 0; i < 100;i++){
            int h =0;
            h ^= i;
            h ^= (h >>> 20) ^ (h >>> 12);

            if ( (h ^ (h >>> 7) ^ (h >>> 4) )== 15){
                System.out.println("i:" + i);
            }
        }
    }

    public static int intHash(int[] a){
        if (a == null)
            return 0;

        int result = 1;
        for (int element : a)
            result = 31 * result + element;

        return result;
    }
}
