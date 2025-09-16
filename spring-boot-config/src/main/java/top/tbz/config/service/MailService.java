package top.tbz.config.service;

import org.springframework.web.multipart.MultipartFile;
import top.tbz.config.Enum.ResultStatus;
import top.tbz.config.model.Mail;

public interface MailService {
    ResultStatus sendSimpleMail(Mail mail);

    ResultStatus sendHtmlMail(Mail mail);

    ResultStatus sendAttachmentsMail(Mail mail, MultipartFile[] files);
}

