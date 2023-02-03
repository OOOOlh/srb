package com.lh.srb.core.service;

import com.lh.srb.core.pojo.entity.UserLoginRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户登录记录表 服务类
 * </p>
 *
 * @author Helen
 * @since 2022-04-30
 */
public interface UserLoginRecordService extends IService<UserLoginRecord> {
    List<UserLoginRecord> listTop50(Long userId);

}
