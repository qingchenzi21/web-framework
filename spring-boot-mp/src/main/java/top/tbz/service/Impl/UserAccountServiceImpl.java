package top.tbz.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.tbz.entity.UserAccount;
import top.tbz.mapper.UserAccountMapper;
import top.tbz.service.UserAccountService;

/**
 * @author tbz
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {
}
