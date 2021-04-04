package com.misumi.service.internal_trainserver.handler;

import com.baomidou.mybatisplus.toolkit.StringUtils;

public class ResponseReturnUtils {


    /**
     * 请求成功时封装数据
     *
     * @param data 数据
     * @return 返回BaseResponseVo封装后的数据
     */
    public static BaseResponse success(Object data) {
        ResponseReturn result = new ResponseReturn();
        result.setCode(ResponseEnum.SUCCESS.getRtn());
        result.setMsg(ResponseEnum.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    /**
     * 请求成功时封装数据
     *
     * @return 返回BaseResponseVo封装后的数据
     */
    public static BaseResponse success() {
        return success(null);
    }

    /**
     * 请求失败结果封装
     *
     * @param responseEnum 响应状态码
     * @param message      响应信息
     * @return 返回BaseResponseVo封装后的数据
     */
    public static BaseResponse error(ResponseEnum responseEnum, String message) {
        BaseResponse result = new BaseResponse();
        result.code=(responseEnum.getRtn());
        String msg = StringUtils.isEmpty(message) ? responseEnum.getMessage() : message;
        result.setMsg(msg);
        return result;
    }

    /**
     * 请求失败结果封装
     *
     * @param responseEnum 响应状态码
     * @return 返回BaseResponseVo封装后的数据
     */
    public static BaseResponse error(ResponseEnum responseEnum) {
        return error(responseEnum, null);
    }
}
