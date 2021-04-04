package com.misumi.service.internal_trainserver.handler;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseReturn<T>  extends BaseResponse{
    private T data;
}
