package top.tbz.config.Test;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import top.tbz.config.Enum.ResultStatus;
import top.tbz.config.model.Mail;
import top.tbz.config.service.MailService;

import java.io.File;

@SpringBootTest
public class MailServiceTest {
    @Resource
    private MailService mailService;

    @Test
    void sendSimpleMail() {
        Mail mail = new Mail();
        mail.setTo("1620638025@qq.com");
        mail.setSubject("测试简单邮件");
        mail.setContent("简单邮件内容");
        ResultStatus resultStatus=mailService.sendSimpleMail(mail);
        assert  resultStatus == ResultStatus.SUCCESS;
    }

    @Test
    void sendAttachmentsMail() throws Exception {
        Mail mail=new Mail();
    mail.setTo("1620638025@qq.com");
    mail.setSubject("测试带附件的邮件");
    mail.setContent("带附件的邮件内容");// 本地文
    File file1=new File("C:\\Users\\86180\\Pictures\\联想截图\\1.jpg");
    File file2=new File("C:\\Users\\86180\\Pictures\\联想截图\\1.jpg");
    // File 转换为 MultipartFile
    MultipartFile[] files=new MultipartFile[2];
    files[0] = new MockMultipartFile(
            file1.getName(),// 参数名
            file1.getName(),// 原始文件名
            "image/jpeg",// contentType
            FileCopyUtils.copyToByteArray(file1)// 文件字节
    );
    files[1]=new MockMultipartFile(
            file2.getName(),
            file2.getName(),
            "image/jpeg",
            FileCopyUtils.copyToByteArray(file2)
    );
    mailService.sendAttachmentsMail(mail,files);
    }


    }
