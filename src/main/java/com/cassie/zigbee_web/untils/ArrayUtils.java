package com.cassie.zigbee_web.untils;

public class ArrayUtils {
    //合并数组
    public static byte[] concat(byte[] firstArray,byte[] secondArray){
        if (firstArray == null || secondArray == null){
            return null;
        }
        byte[] bytes = new byte[firstArray.length + secondArray.length];
        System.arraycopy(firstArray,0,bytes,0,firstArray.length);
        System.arraycopy(secondArray,0,bytes,firstArray.length,secondArray.length);
        return bytes;
    }
}
