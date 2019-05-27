package com.imooc.sell.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@RestController("demo")
@RequestMapping("/wx")
public class DemoController {
    //这里的token要和微信测试号网页填写的token一样
    public static final String TOKEN = "okjfdlsf_lsdfjdslkfj_token";

    @GetMapping("/get")
    public void get(String signature,String timestamp,String nonce,String echostr, HttpServletResponse response) throws IOException, NoSuchAlgorithmException, NoSuchAlgorithmException {
        // 将token、timestamp、nonce三个参数进行字典序排序
        System.out.println("signature:"+signature);
        System.out.println("timestamp:"+timestamp);
        System.out.println("nonce:"+nonce);
        System.out.println("echostr:"+echostr);
        System.out.println("TOKEN:"+TOKEN);
        String[] params = new String[] { TOKEN, timestamp, nonce };
        Arrays.sort(params);
        // 将三个参数字符串拼接成一个字符串进行sha1加密
        String clearText = params[0] + params[1] + params[2];
        String algorithm = "SHA-1";
        String sign = new String(
                org.apache.commons.codec.binary.Hex.encodeHex(MessageDigest.getInstance(algorithm).digest((clearText).getBytes()), true));
        // 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        if (signature.equals(sign)) {
            try {
                response.getWriter().print(echostr);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
