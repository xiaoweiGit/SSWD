package com.misumi.service.internal_trainserver.handler;

import com.alibaba.fastjson.JSON;
import groovy.util.logging.Slf4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Log4j2
@ControllerAdvice(annotations = {RestController.class})
public class RestResponseHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        //判断支持的类型，因为我们定义的BaseResponseVo 里面的data可能是任何类型，这里就不判断统一放过
        //如果你想对执行的返回体进行操作，可将上方的Object换成你自己的类型
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        log.info("--Response type={}", body.getClass().getName());
        BaseResponse result = null;
        //兼容原来的接口返回
        if (body instanceof ResponseReturn) {
            result = (ResponseReturn) body;
        } else if (body instanceof ResponsePageReturn) {
            result = (ResponsePageReturn) body;
        } else if (body instanceof BaseResponse) {
            result = (BaseResponse) body;
        } else if(body instanceof Resource){//如果是资源，直接返回数据
            return body;
        }
        else {
            result = ResponseReturnUtils.success(body);
        }
        //debug时打印响应结果
        if (log.isDebugEnabled()) {
            log.trace("--Response：{} ", JSON.toJSONString(result));
        }
        //处理返回值是String的情况
        if (body instanceof String) {
            return JSON.toJSONString(result);
        }
        return result;

    }

}
