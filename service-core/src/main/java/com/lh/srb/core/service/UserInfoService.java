package com.lh.srb.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lh.srb.core.pojo.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lh.srb.core.pojo.query.UserInfoQuery;
import com.lh.srb.core.pojo.vo.LoginVO;
import com.lh.srb.core.pojo.vo.RegisterVO;
import com.lh.srb.core.pojo.vo.UserInfoVO;

/**
 * <p>
 * 用户基本信息 服务类
 * </p>
 *
 * @author Helen
 * @since 2022-04-30
 */
public interface UserInfoService extends IService<UserInfo> {
    void register(RegisterVO registerVO);
    UserInfoVO login(LoginVO loginVO, String ip);
    IPage<UserInfo> listPage(Page<UserInfo> pageParam, UserInfoQuery userInfoQuery);
    void lock(Long id, Integer status);
    boolean checkMobile(String mobile);
}
