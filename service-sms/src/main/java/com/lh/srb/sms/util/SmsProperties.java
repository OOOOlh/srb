package com.lh.srb.sms.util;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "rly.sms")
public class SmsProperties implements InitializingBean {
    private String accountSId;
    private String accountToken;
    private String appId;
    private String serverIp;
    private String serverPort;

    public static String ACCOUNT_SID;
    public static String ACCOUNT_TOKEN;
    public static String APP_ID;
    public static String SERVER_IP;
    public static String SERVER_PORT;
    @Override
    public void afterPropertiesSet() throws Exception {
        ACCOUNT_SID = accountSId;
        ACCOUNT_TOKEN = accountToken;
        APP_ID = appId;
        SERVER_IP = serverIp;
        SERVER_PORT = serverPort;
    }
}
