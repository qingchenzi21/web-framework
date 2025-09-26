package top.tbz.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.tbz.entity.UserAccount;
import top.tbz.service.UserAccountService;

import java.util.List;

/**
 * @author tbz
 */
@RestController
@RequestMapping("/user-account")
@RequiredArgsConstructor
@Validated
public class UserAccountController {

    private final UserAccountService userAccountService;

    /**
     * 创建用户账户
     */
    @PostMapping
    public ResponseEntity<UserAccount> createUser(@Valid @RequestBody UserAccount userAccount) {
        boolean saved = userAccountService.save(userAccount);
        return saved ? ResponseEntity.ok(userAccount) : ResponseEntity.badRequest().build();
    }

    /**
     * 根据ID获取用户账户
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getUserById(@PathVariable @NotNull Long id) {
        UserAccount user = userAccountService.getById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    /**
     * 获取所有用户账户列表
     */
    @GetMapping
    public ResponseEntity<List<UserAccount>> getAllUsers() {
        List<UserAccount> users = userAccountService.list();
        return ResponseEntity.ok(users);
    }

    /**
     * 分页查询用户账户
     */
    @GetMapping("/page")
    public ResponseEntity<IPage<UserAccount>> getUsersPage(
            @RequestParam(defaultValue = "1") int current,
            @RequestParam(defaultValue = "10") int size) {
        Page<UserAccount> page = new Page<>(current, size);
        IPage<UserAccount> result = userAccountService.page(page);
        return ResponseEntity.ok(result);
    }

    /**
     * 根据用户名查询用户
     */
    @GetMapping("/username/{username}")
    public ResponseEntity<UserAccount> getUserByUsername(@PathVariable String username) {
        LambdaQueryWrapper<UserAccount> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserAccount::getUsername, username);
        UserAccount user = userAccountService.getOne(queryWrapper);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    /**
     * 根据邮箱查询用户
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<UserAccount> getUserByEmail(@PathVariable String email) {
        LambdaQueryWrapper<UserAccount> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserAccount::getEmail, email);
        UserAccount user = userAccountService.getOne(queryWrapper);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    /**
     * 根据状态查询用户列表
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<List<UserAccount>> getUsersByStatus(@PathVariable Integer status) {
        LambdaQueryWrapper<UserAccount> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserAccount::getStatus, status);
        List<UserAccount> users = userAccountService.list(queryWrapper);
        return ResponseEntity.ok(users);
    }

    /**
     * 模糊查询用户昵称
     */
    @GetMapping("/search")
    public ResponseEntity<List<UserAccount>> searchUsersByNickname(@RequestParam String nickname) {
        LambdaQueryWrapper<UserAccount> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(UserAccount::getNickname, nickname);
        List<UserAccount> users = userAccountService.list(queryWrapper);
        return ResponseEntity.ok(users);
    }

    /**
     * 更新用户账户
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserAccount> updateUser(
            @PathVariable @NotNull Long id,
            @Valid @RequestBody UserAccount userAccount) {
        userAccount.setId(id);
        boolean updated = userAccountService.updateById(userAccount);
        return updated ? ResponseEntity.ok(userAccount) : ResponseEntity.badRequest().build();
    }

    /**
     * 删除用户账户（逻辑删除）
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable @NotNull Long id) {
        boolean deleted = userAccountService.removeById(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    /**
     * 批量创建用户账户
     */
    @PostMapping("/batch")
    public ResponseEntity<List<UserAccount>> createUsers(@Valid @RequestBody List<UserAccount> userAccounts) {
        boolean saved = userAccountService.saveBatch(userAccounts);
        return saved ? ResponseEntity.ok(userAccounts) : ResponseEntity.badRequest().build();
    }

    /**
     * 批量删除用户账户
     */
    @DeleteMapping("/batch")
    public ResponseEntity<Void> deleteUsers(@RequestBody List<Long> ids) {
        boolean deleted = userAccountService.removeByIds(ids);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }

    /**
     * 获取用户总数
     */
    @GetMapping("/count")
    public ResponseEntity<Long> getUserCount() {
        long count = userAccountService.count();
        return ResponseEntity.ok(count);
    }

    /**
     * 获取活跃用户数量
     */
    @GetMapping("/count/active")
    public ResponseEntity<Long> getActiveUserCount() {
        LambdaQueryWrapper<UserAccount> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserAccount::getStatus, true);
        long count = userAccountService.count(queryWrapper);
        return ResponseEntity.ok(count);
    }

    /**
     * 启用/禁用用户账户
     */
    @PatchMapping("/{id}/status")
    public ResponseEntity<UserAccount> updateUserStatus(
            @PathVariable @NotNull Long id,
            @RequestParam Integer status) {
        UserAccount user = userAccountService.getById(id);
        if (user != null) {
            user.setStatus(status);
            boolean updated = userAccountService.updateById(user);
            return updated ? ResponseEntity.ok(user) : ResponseEntity.badRequest().build();
        }
        return ResponseEntity.notFound().build();
    }


}

