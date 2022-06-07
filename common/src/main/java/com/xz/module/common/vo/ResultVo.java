package com.xz.module.common.vo;


import com.xz.module.common.base.ResultStatus;
import com.xz.module.common.exception.DefinitionException;

import java.io.Serializable;

/**
 * @author XiaoZe
 * @email czr2001@outlook.com
 * @date 2022/6/7 14:21
 * 通用json返回实体
 */
public class ResultVo implements Serializable {
    private int code;
    private String msg;
    private Object data;

    /**
     * 成功返回的结果
     *
     * @param data
     * @return
     */
    public static ResultVo success(Object data) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ResultStatus.STATUS_SUCCESS.getCode());
        resultVo.setMsg(ResultStatus.STATUS_SUCCESS.getMsg());
        resultVo.setData(data);
        return resultVo;
    }

    /**
     * 自定义异常返回的结果
     */
    public static ResultVo defineError(DefinitionException de) {
        ResultVo result = new ResultVo();
        result.setCode(de.getCode());
        result.setMsg(de.getMsg());
        return result;
    }

    /**
     * 其他异常处理方法返回的结果
     */
    public static ResultVo otherError(ResultStatus status) {
        ResultVo result = new ResultVo();
        result.setMsg(status.getMsg());
        result.setCode(status.getCode());
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
