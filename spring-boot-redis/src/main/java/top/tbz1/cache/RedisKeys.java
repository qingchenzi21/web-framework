package top.tbz1.cache;

public class RedisKeys {

    public static String getSmsKey(String phone){
        return "sms:captcha:"+phone;
    }
}
