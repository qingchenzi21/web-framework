package top.tbz.config.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.tbz.config.service.MailService;
import top.tbz.config.Enum.ResultStatus;
import top.tbz.config.common.ApiResponse;
import top.tbz.config.model.Mail;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Resource
    private MailService mailService;

    @PostMapping("/simple")
    public ResponseEntity<ApiResponse<ResultStatus>> sendSimpleMail(@Valid @RequestBody Mail mail){
        ResultStatus rs = mailService.sendSimpleMail(mail);
        if(rs == ResultStatus.SUCCESS){
            return ResponseEntity.ok(ApiResponse.success("发送成功",rs));
        }
        //业务失败返回400
        return ResponseEntity.ok(ApiResponse.fail("发送失败"));
    }

    @PostMapping("/html")
    public ResponseEntity<ApiResponse<ResultStatus>> sendHtmlMail(@Valid @RequestBody Mail mail){
        ResultStatus rs = mailService.sendHtmlMail(mail);
        return rs == ResultStatus.SUCCESS ?
                ResponseEntity.ok(ApiResponse.success("发送成功",rs)) :
                ResponseEntity.badRequest().body(ApiResponse.fail("发送失败"));
    }

    @PostMapping(value = "/attachments", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<ResultStatus>> sendAttachmentsMail(@Valid @RequestParam("to") String to,
                                                                         @RequestParam("subject") String subject,
                                                                         @RequestParam("text") String text,
                                                                         @RequestPart("files") MultipartFile[] files){
        Mail mail = new Mail();
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setContent(text);
        ResultStatus rs = mailService.sendAttachmentsMail(mail,files);
        return rs == ResultStatus.SUCCESS ?
                ResponseEntity.ok(ApiResponse.success("发送成功",rs)) :
                ResponseEntity.badRequest().body(ApiResponse.fail("发送失败"));
    }
}
