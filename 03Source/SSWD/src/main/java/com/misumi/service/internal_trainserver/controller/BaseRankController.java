package com.misumi.service.internal_trainserver.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.misumi.service.internal_trainserver.handler.ResponseEnum;
import com.misumi.service.internal_trainserver.handler.ResponseReturnUtils;
import com.misumi.service.internal_trainserver.handler.aop.UserAuth;
import com.misumi.service.internal_trainserver.pojo.entity.BaseRank;
import com.misumi.service.internal_trainserver.pojo.entity.BaseUser;
import com.misumi.service.internal_trainserver.service.BaseRankService;
import com.misumi.service.internal_trainserver.service.BaseUserService;
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
@Api(value = "BaseRank RESTful", description = "职级")
@RestController
@Controller
@RequestMapping("api/baseRank")
public class BaseRankController {

    @Resource
    BaseRankService baseRankService;

    @Resource
    BaseUserService baseUserService;

    @ApiOperation(value = "查询职级", notes = "查询职级")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<BaseRank> list() {
        List<BaseRank> baseRankList = baseRankService.findAll();
        return baseRankList;
    }

    @UserAuth
    @ApiOperation(value ="新增职级",notes = "新增职级")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object add(@RequestBody BaseRank m, @RequestHeader int id) {

        BaseUser user = baseUserService.selectById(id);
        BaseRank entity = new BaseRank();
        if (user != null) {
            entity.setRankname(m.getRankname());
            entity.setRankno(m.getRankno());
            entity.setRemark(m.getRemark());
            entity.setCreatetime(new Date());
            entity.setCreateuser(user.getSname());
            entity.setLastupdateuser(user.getSname());

            baseRankService.insert(entity);
        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return baseRankService.selectById(entity.getRankid());
    }

    @UserAuth
    @ApiOperation(value = "删除职级", notes = "删除职级")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(int rankid,@RequestHeader int id) {
        BaseUser user = baseUserService.selectOne(
                new EntityWrapper<BaseUser>()
                        .eq("delstate",1)
                        .eq("uid",id)
        );
        BaseRank rank = baseRankService.selectOne(
                new EntityWrapper<BaseRank>()
                        .eq("rankid", rankid)
        );

        if (user != null && rank.getRankid() != user.getRankid()) {//不能删除本账号职位
            //删除关联数据（数据库里彻底删除，非改删除状态值）
            baseUserService.deleteById(
                    new EntityWrapper<BaseUser>()
                            .eq("rankid",rankid)
            );

            return baseRankService.deleteById(new EntityWrapper<BaseRank>().eq("rankid",rankid));
        }
        else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
    }

    @UserAuth
    @ApiOperation(value ="更新职级",notes = "更新职级")
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public Object update(@RequestBody BaseRank m, @RequestHeader int id) {

        BaseUser user = baseUserService.selectById(id);
        BaseRank entity = new BaseRank();
        if (user != null) {
            if (m.getRankid() > 0) {
                entity.setRankname(m.getRankname());
                entity.setRankno(m.getRankno());
                entity.setRemark(m.getRemark());
                entity.setLastupdateuser(user.getSname());

                baseRankService.insert(entity);
            } else {
                return ResponseReturnUtils.error(ResponseEnum.BAD_ID);
            }
        } else {
            return ResponseReturnUtils.error(ResponseEnum.USER_BAD_REQUEST);
        }
        return baseRankService.selectById(entity.getRankid());
    }
}
