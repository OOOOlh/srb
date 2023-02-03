package com.lh.srb.core.service.impl;

import com.lh.srb.core.pojo.entity.UserAccount;
import com.lh.srb.core.mapper.UserAccountMapper;
import com.lh.srb.core.service.UserAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户账户 服务实现类
 * </p>
 *
 * @author Helen
 * @since 2022-04-30
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements UserAccountService {

}
