package com.misumi.service.internal_trainserver.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.misumi.service.internal_trainserver.handler.ResponseEnum;
import com.misumi.service.internal_trainserver.handler.ResponseReturnUtils;
import com.misumi.service.internal_trainserver.handler.aop.UserAuth;
import com.misumi.service.internal_trainserver.pojo.entity.BaseUser;
import com.misumi.service.internal_trainserver.pojo.entity.NewsCategory;
import com.misumi.service.internal_trainserver.pojo.entity.NewsInfo;
import com.misumi.service.internal_trainserver.service.BaseUserService;
import com.misumi.service.internal_trainserver.service.NewsCategoryService;
import com.misumi.service.internal_trainserver.service.NewsInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bill
 * @since 2019-04-11
 */
@Api(value = "NewsInfo RESTful", description = "新闻")
@RestController
@Controller
@RequestMapping("api/newsInfo")
public class NewsInfoController {

    @Resource
    NewsInfoService newsInfoService;

    @Resource
    NewsCategoryService newsCategoryService;

    @Resource
    BaseUserService baseUserService;

    @ApiOperation(value = "查询新闻", notes = "查询新闻")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<NewsInfo> list() {
        List<NewsInfo> newsInfoList = newsInfoService.findAll();
        return newsInfoList;
    }

    @ApiOperation(value ="新增新闻",notes = "新增新闻")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object add(@RequestBody NewsInfo m, @RequestHeader int id) {
        BaseUser user = baseUserService.selectById(id);
        NewsInfo entity = new NewsInfo();
        if (user != null) {
            NewsCategory newsCategory = newsCategoryService.selectById(m.getCategoryid());
            if(newsCategory != null) {
                entity.setNewtitile(m.getNewtitile());
                entity.setUrl(m.getUrl());
                entity.setContent(m.getContent());
                entity.setNewstatus(m.getNewstatus());
                entity.setCreatetime(new Date());

                newsInfoService.insert(entity);
            }

        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return newsInfoService.selectById(entity.getNewid());
    }

    @UserAuth
    @ApiOperation(value = "删除新闻", notes = "删除新闻")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(int newid,@RequestHeader int id) {
        BaseUser user = baseUserService.selectOne(
                new EntityWrapper<BaseUser>()
                        .eq("delstate",1)
                        .eq("uid",id)
        );

        if (user != null) {
            return baseUserService.deleteById(new EntityWrapper<NewsInfo>().eq("newid",newid));
        }
        else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
    }

    @UserAuth
    @ApiOperation(value ="更新新闻",notes = "更新新闻")
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public Object update(@RequestBody NewsInfo m, @RequestHeader int id) {
        BaseUser user = baseUserService.selectById(id);
        NewsInfo entity = new NewsInfo();
        if (user != null) {
            NewsCategory newsCategory = newsCategoryService.selectById(m.getCategoryid());
            if(newsCategory != null) {
                if (m.getNewid() > 0) {
                    entity.setNewtitile(m.getNewtitile());
                    entity.setUrl(m.getUrl());
                    entity.setContent(m.getContent());
                    entity.setNewstatus(m.getNewstatus());

                    newsInfoService.insert(entity);
                } else {
                    return ResponseReturnUtils.error(ResponseEnum.BAD_ID);
                }
                entity.setNewtitile(m.getNewtitile());
                entity.setUrl(m.getUrl());
                entity.setContent(m.getContent());
                entity.setNewstatus(m.getNewstatus());
                entity.setCreatetime(new Date());

                newsInfoService.insert(entity);
            }

        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return newsInfoService.selectById(entity.getNewid());
    }
}
