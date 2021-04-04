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
@Api(value = "NewsCategory RESTful", description = "新闻分类")
@RestController
@Controller
@RequestMapping("api/newsCategory")
public class NewsCategoryController {

    @Resource
    NewsCategoryService newsCategoryService;

    @Resource
    BaseUserService baseUserService;

    @ApiOperation(value = "查询新闻分类", notes = "查询新闻分类")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<NewsCategory> list() {
        List<NewsCategory> newsCategoryList = newsCategoryService.findAll();
        return newsCategoryList;
    }

    @ApiOperation(value ="新增新闻分类",notes = "新增新闻分类")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object add(@RequestBody NewsCategory m, @RequestHeader int id) {
        BaseUser user = baseUserService.selectById(id);
        NewsCategory entity = new NewsCategory();
        if (user != null) {
            entity.setCategoryname(m.getCategoryname());
            entity.setSerino(m.getSerino());
            entity.setCreatetime(new Date());

            newsCategoryService.insert(entity);

        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return newsCategoryService.selectById(entity.getCategoryid());
    }

    @UserAuth
    @ApiOperation(value = "删除新闻分类", notes = "删除新闻分类")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(int categoryid,@RequestHeader int id) {
        BaseUser user = baseUserService.selectOne(
                new EntityWrapper<BaseUser>()
                        .eq("delstate",1)
                        .eq("uid",id)
        );

        if (user != null) {
            //删除关联数据（数据库里彻底删除，非改删除状态值）
            baseUserService.deleteById(new EntityWrapper<NewsInfo>().eq("categoryid",categoryid));

            return newsCategoryService.deleteById(new EntityWrapper<NewsCategory>().eq("categoryid",categoryid));
        }
        else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
    }

    @UserAuth
    @ApiOperation(value ="更新新闻分类",notes = "更新新闻分类")
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public Object update(@RequestBody NewsCategory m, @RequestHeader int id) {
        BaseUser user = baseUserService.selectById(id);
        NewsCategory entity = new NewsCategory();
        if (user != null) {
            if (m.getCategoryid() > 0) {
                entity.setCategoryname(m.getCategoryname());
                entity.setSerino(m.getSerino());

                newsCategoryService.insert(entity);
            } else {
                return ResponseReturnUtils.error(ResponseEnum.BAD_ID);
            }
        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return newsCategoryService.selectById(entity.getCategoryid());
    }
}
