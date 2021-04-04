package com.misumi.service.internal_trainserver.handler;

import java.util.ArrayList;
import java.util.List;

public class ResponsePageReturn<T>  extends  ResponseReturn{
    /**
     * 当前页
     */
    private Integer currentPage;
    /**
     * 每页记录数
     */
    private Integer pageSize;
    /**
     * 总记录数
     */
    private Long recordCount;
    /**
     * 当前页记录
     */
    private Integer pageCount;
    /**
     * 总页数
     */
   // private Integer tatalPage;

    /**
     * 数据
     */
    private List<T> data=new ArrayList<>();
}
