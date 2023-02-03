package com.lh.srb.sms.service.impl;

import com.cloopen.rest.sdk.BodyType;
import com.lh.srb.sms.service.SmsService;
import com.lh.srb.sms.util.SmsProperties;
import org.springframework.stereotype.Service;
import com.cloopen.rest.sdk.CCPRestSmsSDK;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class SmsServiceImpl implements SmsService {
    @Override
    public void send(String mobile, Map<String, Object> para) {
        CCPRestSmsSDK ccpRestSmsSDK = new CCPRestSmsSDK();
        // 初始化服务器地址和端口，生产环境配置成app.cloopen.com，端口是8883
        ccpRestSmsSDK.init(SmsProperties.SERVER_IP, SmsProperties.SERVER_PORT);
        // 初始化主账号名称和主账号令牌，登陆云通讯网站后，可在控制首页中看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN
        ccpRestSmsSDK.setAccount(SmsProperties.ACCOUNT_SID, SmsProperties.ACCOUNT_TOKEN);
        ccpRestSmsSDK.setAppId(SmsProperties.APP_ID);
        ccpRestSmsSDK.setBodyType(BodyType.Type_JSON);

        String[] datas = {(String) para.get("code"), "5"};
        Map<String, Object> result = ccpRestSmsSDK.sendTemplateSMS(mobile, "1", datas);

        if("000000".equals(result.get("statusCode"))){
            //正常返回输出data包体信息（map）
            HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            System.out.println("短信发送成功");
            for(String key:keySet){
                Object object = data.get(key);
                System.out.println(key +" = "+object);
            }
        }else{
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
        }
    }
}
