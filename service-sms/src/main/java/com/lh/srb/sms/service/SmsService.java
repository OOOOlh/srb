package com.lh.srb.sms.service;

import java.util.Map;

public interface SmsService {
    void send(String mobile, Map<String, Object> para);
}
