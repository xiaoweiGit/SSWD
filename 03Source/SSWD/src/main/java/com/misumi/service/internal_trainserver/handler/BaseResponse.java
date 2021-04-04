package com.misumi.service.internal_trainserver.handler;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseResponse {
    protected Integer code;
    protected  String msg;
}
