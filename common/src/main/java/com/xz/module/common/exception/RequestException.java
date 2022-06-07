package com.xz.module.common.exception;


import com.xz.module.common.base.ResultStatus;

/**
 * 自定义请求异常
 */
public class RequestException extends DefinitionException {

    /**
     * 默认请求异常信息
     */
    public RequestException() {
        super(ResultStatus.STATUS_REQUEST_FREQUENT.getCode(), ResultStatus.STATUS_REQUEST_FREQUENT.getMsg());
    }

    /**
     * 自定义异常信息
     */
    public RequestException(String errorMsg) {
        super(ResultStatus.STATUS_REQUEST_FREQUENT.getCode(), errorMsg);
    }

    /**
     * 自定义异常代码
     * 自定义异常信息
     */
    public RequestException(Integer errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }
}