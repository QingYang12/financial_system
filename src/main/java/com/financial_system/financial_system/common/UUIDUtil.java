package com.financial_system.financial_system.common;

import java.util.UUID;

public class UUIDUtil {
    public static String getuuid(){

        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        return uuid;
    }

}
