package com.misumi.service.internal_trainserver.handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.message.AuthException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;

@Log4j2
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public BaseResponse exceptionHandler(Exception e) {
        e.printStackTrace();
        //参数校验错误
        if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            List<ObjectError> objectErrors = bindException.getBindingResult().getAllErrors();
            return getValidExceptionResult(objectErrors);
        }
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException bindException = (MethodArgumentNotValidException) e;
            List<ObjectError> objectErrors = bindException.getBindingResult().getAllErrors();
            return getValidExceptionResult(objectErrors);
        }
        //post请求未传参数
        if (e instanceof HttpMessageNotReadableException) {
            return ResponseReturnUtils.error(ResponseEnum.BAD_REQUEST);
        }

        //请求Content type不支持
        if (e instanceof HttpMediaTypeNotSupportedException) {
            return ResponseReturnUtils.error(ResponseEnum.MEDIA_TYPE_NOT_SUPPORTED);
        }
        //签名异常
        if(e instanceof UndeclaredThrowableException)
        {
            return  ResponseReturnUtils.error(ResponseEnum.BAD_ID);
        }

        BaseResponse ret= ResponseReturnUtils.error(ResponseEnum.SERVER_ERROR);
        ret.setMsg(e.getMessage());
        return ret;
    }

    //参数校验异常处理
    private BaseResponse getValidExceptionResult(List<ObjectError> objectErrors) {
        StringBuilder sb = new StringBuilder();
        for (ObjectError error : objectErrors) {
            sb.append(error.getDefaultMessage()).append(";");
        }
        String message = sb.length() > 0 ? sb.toString().substring(0, sb.length() - 1) : sb.toString();
        return ResponseReturnUtils.error(ResponseEnum.BAD_REQUEST_PARAMETER, message);
    }
}
