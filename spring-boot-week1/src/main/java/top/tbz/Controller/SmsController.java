package top.tbz.Controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.tbz.service.SmsService;

@RestController
public class SmsController {
    @Resource
    private SmsService smsService;

    @GetMapping("/sms")
    public void sendSms(String phone){
        smsService.sendSms(phone);
    }
}
