package com.redteamobile.ticket.controller;

import com.redteamobile.ticket.dto.ResponseStruct;
import com.redteamobile.ticket.enums.BaseResultEnum;
import com.redteamobile.ticket.i18n.LocaleMessageSource;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    private LocaleMessageSource localeMessageSource;

    public ResponseStruct succ(Object obj) {
        return ResponseStruct.build().setCode(BaseResultEnum.SUCCESS.getCode()).setSuccess(true).setMsg(BaseResultEnum.SUCCESS.getMessage()).setObj(obj);
    }

    public ResponseStruct succ(Object obj, String code, String msg) {
        return ResponseStruct.build().setObj(obj).setCode(code).setMsg(msg).setSuccess(true);
    }

    public ResponseStruct succ() {
        return ResponseStruct.build().setCode(BaseResultEnum.SUCCESS.getCode()).setSuccess(true).setMsg(BaseResultEnum.SUCCESS.getMessage());
    }

    public ResponseStruct failedWithCode(String code) {
        return ResponseStruct.build().setCode(code).setSuccess(false).setMsg(localeMessageSource.getMessage(code));
    }

    public ResponseStruct failedWithMsg(String msg) {
        return ResponseStruct.build().setMsg(msg).setSuccess(false);
    }

    public ResponseStruct failed(String code, String message) {
        return ResponseStruct.build().setCode(code).setSuccess(false).setMsg(message);
    }

    public ResponseStruct failed(String code, Object obj) {
        return ResponseStruct.build().setCode(code).setSuccess(false).setMsg(localeMessageSource.getMessage(code)).setObj(obj);
    }

}
