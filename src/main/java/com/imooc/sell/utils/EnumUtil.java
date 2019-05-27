package com.imooc.sell.utils;

import com.imooc.sell.enums.CodeEnum;

/**
 * 通过状态码，返回枚举信息工具，在OrderDTO中使用了，用于返回前端信息，而不是状态码
 */
public class EnumUtil {

    public static <T extends CodeEnum>T getByCode(Integer code, Class<T> enumClass){
        for(T each: enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
