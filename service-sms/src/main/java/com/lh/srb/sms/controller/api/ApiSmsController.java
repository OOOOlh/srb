package com.lh.srb.sms.controller.api;

import com.lh.common.exception.Assert;
import com.lh.common.result.R;
import com.lh.common.result.ResponseEnum;
import com.lh.common.util.RandomUtils;
import com.lh.common.util.RegexValidateUtils;
import com.lh.srb.sms.client.CoreUserInfoClient;
import com.lh.srb.sms.service.SmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Api(tags = "短信管理")
@RequestMapping("/api/sms")
@RestController
//@CrossOrigin
@Slf4j
public class ApiSmsController {

    @Resource
    private CoreUserInfoClient coreUserInfoClient;

    @Resource
    private SmsService smsService;

    @Resource
    private RedisTemplate redisTemplate;

    @ApiOperation("获取验证码")
    @GetMapping("/send/{mobile}")
    public R send(
            @ApiParam(value = "手机号", required = true)
            @PathVariable String mobile
    ){
        //校验手机号码不能为空
        Assert.notEmpty(mobile, ResponseEnum.MOBILE_NULL_ERROR);
        //校验手机号码合法
        Assert.isTrue(RegexValidateUtils.checkCellphone(mobile), ResponseEnum.MOBILE_ERROR);

        //手机号是否注册
        boolean result = coreUserInfoClient.checkMobile(mobile);
        log.info("result" + result);
        Assert.isTrue(!result, ResponseEnum.MOBILE_EXIST_ERROR);

        //生成验证码
        String code = RandomUtils.getFourBitRandom();

        HashMap<String , Object> map = new HashMap<>();
        map.put("code", code);
        smsService.send(mobile, map);

        //将验证码存入Redis
        redisTemplate.opsForValue().set("srb:sms:code:" + mobile, code, 5, TimeUnit.MINUTES);
//        System.out.println("短信发送成功C");
        return R.ok().message("短信发送成功");
    }
}
