package com.redteamobile.ticket.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *  @author ericzhao
 *  @mail zijian.zhao@redteamobile.com
 *  @date 2022/3/12 13:20
 *  @description 通用结果对象，定义通用成功结果和失败结果
 */
@Getter
@NoArgsConstructor
public enum BaseResultEnum implements IBaseResult {

    SUCCESS("00000", "成功"),


    ERR_INTERNAL_SERVER_ERROR("00001", "服务端内部错误"),
    ERR_COMMON("00002", "服务端通用业务处理异常"),
    ERR_BAD_REQUEST("00004", "请求不合法或参数错误"),
    ERR_PERMISSION_DENIED("00005", "无权限进行该操作"),
    ERR_MISSING_PARAMETER("00006", "参数缺失"),
    ERR_IO_ERROR("00007", "IO错误"),
    ERR_REQUEST_HEADER_SECURITY_CHECK_ERROR("00008", "请求头安全校验失败"),
    ERR_AUTH_FAILED("00009", "鉴权失败"),
    ;

    BaseResultEnum(String code, String message){
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage()
    {
        return message;
    }

    @Override
    public BaseResultEnum setMessage(String message) {
        this.message = message;
        return this;
    }
}
