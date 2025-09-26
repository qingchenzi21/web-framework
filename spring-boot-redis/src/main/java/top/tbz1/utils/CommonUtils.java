package top.tbz1.utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author kimihiro
 */
public class CommonUtils {

    /**
     * 校验手机号
     * @param phone 手机号
     * @return 校验结果
     */
    public static boolean checkPhone(String phone) {
        if (phone == null || phone.length() != 11) {
            return false;
        }
        // 中国大陆手机号正则
        String regex = "^1[3-9]\\d{9}$";
        return phone.matches(regex);
    }

    /**
     * 生成4位随机验证码
     * @return 验证码
     */
    public static int generateCode() {
        return ThreadLocalRandom.current().nextInt(1000, 9999);
    }
}
