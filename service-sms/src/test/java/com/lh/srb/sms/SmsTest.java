package com.lh.srb.sms;

import com.lh.srb.sms.service.SmsService;
import com.lh.srb.sms.util.SmsProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SmsTest {

    @Resource
    private SmsService smsService;

    @Test
    public void test(){
        Map<String, Object> map = new HashMap<>();
        map.put("code", "6666");
        smsService.send("18530668925", map);
    }

    @Test
    public void testProperties(){
        System.out.println(SmsProperties.ACCOUNT_SID);
        System.out.println(SmsProperties.ACCOUNT_TOKEN);
        System.out.println(SmsProperties.APP_ID);
    }
}
