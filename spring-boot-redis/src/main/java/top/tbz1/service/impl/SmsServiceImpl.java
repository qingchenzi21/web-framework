package top.tbz1.service.impl;

import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.tbz1.cache.RedisCache;
import top.tbz1.cache.RedisKeys;
import top.tbz1.config.CloopenConfig;
import top.tbz1.enums.ErrorCode;
import top.tbz1.exception.ServerException;
import top.tbz1.service.SmsService;
import top.tbz1.utils.CommonUtils;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

/**
 * @author kimihiro
 */
@Slf4j
@Service
@AllArgsConstructor
public class SmsServiceImpl implements SmsService {
    private final CloopenConfig clopenConfig;
    private final RedisCache redisCache;

    /**
     * 发送短信验证码
     *
     * @param phone 手机号
     * @return 发送成功返回true，失败返回false
     */
    @Override
    public boolean sendSms(String phone) {
        // 1. 校验手机号
        if (!CommonUtils.checkPhone(phone)) {
            throw new ServerException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
        // 2. 生成验证码，并存入 Redis，60秒有效
        int code = CommonUtils.generateCode();
        redisCache.set(RedisKeys.getSmsKey(phone), code, 60);
        log.info("发送验证码: {}", code);
        boolean flag = true;
//        flag = send(phone, code);
        return flag;
    }

    /**
     * 发送短信验证码
     *
     * @param phone 手机号
     * @param code  验证码
     * @return 发送成功返回true，失败返回false
     */
    private boolean send(String phone, int code) {
        // 2. 获取配置信息
        String serverIp = clopenConfig.getServerIp();
        String serverPort = clopenConfig.getPort();
        String accountSid = clopenConfig.getAccountSId();
        String accountToken = clopenConfig.getAccountToken();
        String appId = clopenConfig.getAppId();
        String templateId = clopenConfig.getTemplateId();

        // 3. 创建sdk对象
        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init(serverIp, serverPort);
        sdk.setAccount(accountSid, accountToken);
        sdk.setAppId(appId);
        sdk.setBodyType(BodyType.Type_JSON);
        String[] datas = {String.valueOf(code), "1"};
        // 发送短信
        HashMap<String, Object> result = sdk.sendTemplateSMS(phone, templateId, datas, "1234", UUID.randomUUID().toString());
        if ("000000".equals(result.get("statusCode"))) {
            // 正常返回输出data包体信息（map）
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                log.info("{} = {}", key, object);
            }
        } else {
            // 异常返回输出错误码和错误信息
            log.error("错误码= {} 错误信息= {}", result.get("statusCode"), result.get("statusMsg"));
            return false;
        }
        return true;
    }
}
