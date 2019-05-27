package com.imooc.sell.utils;

import com.imooc.sell.vo.RestVO;

public class ResultVOUtil {

    public static RestVO success(Object object){
        RestVO restVO = new RestVO();
        restVO.setData(object);
        restVO.setCode(0);
        restVO.setMsg("成功");
        return restVO;
    }

    public static RestVO success(){
        return success(null);
    }

    public static RestVO error(Integer code, String msg){
        RestVO restVO = new RestVO();
        restVO.setCode(code);
        restVO.setMsg(msg);
        return restVO;
    }
}
