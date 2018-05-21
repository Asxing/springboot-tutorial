package com.holddie.springboot.mybatis.rest.controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.holddie.springboot.mybatis.common.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.plugins.Page;
import com.holddie.springboot.mybatis.rest.service.UserService;
import com.holddie.springboot.mybatis.common.result.JSONResult;
import com.holddie.springboot.mybatis.common.result.TableJSON;
import com.holddie.springboot.mybatis.rest.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.annotations.*;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 * ---------------------------------
 * @author HoldDie
 * @description User 控制器
 * @since 2018-05-21
 */
@RestController
@Api(value="/user", description="User 控制器")
@RequestMapping("/user")
public class UserController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserService userService;

    /**
     * @description : 获取分页列表
     * ---------------------------------
     * @author : HoldDie
     * @since : Create in 2018-05-21
     */
    @GetMapping("/getUserList")
    @ApiOperation(value="/getUserList", notes="获取分页列表")
    public TableJSON<User> getUserList(@ApiParam(name="User",value="User 实体类")User param ,
                                @ApiParam(name="length",value="页大小",required=true,defaultValue = "10")Integer length,
                                @ApiParam(name="pageNo",value="页数",required=true,defaultValue = "1")Integer pageNo) {
            TableJSON<User> resJson=new TableJSON<>();
            pageNo = 1;
            length = 10;
            try {
                Page<User> page=new Page<User>(pageNo,length);
                userService.selectPageWithParam(page, param);
                resJson.setRecordsTotal(page.getTotal());
                resJson.setData(page.getRecords());
                resJson.setSuccess(true);
            }catch (Exception e){
                resJson.setSuccess(false);
                resJson.setMessage("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 通过id获取User
     * ---------------------------------
     * @author : HoldDie
     * @since : Create in 2018-05-21
     */
    @GetMapping("/getUserById")
    @ApiOperation(value="/getUserById", notes="通过id获取User")
    public JSONResult<User> getUserById(@ApiParam(name="id",value="UserID",required=true)Long id) {
            JSONResult<User> resJson = new JSONResult<>();
            try {
                User param= userService.selectOneByObj(id);
                resJson.setData(param);
                resJson.setSuccess(true);
            }catch (Exception e) {
                resJson.setSuccess(false);
                resJson.setMessage("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 通过id删除User
     * ---------------------------------
     * @author : HoldDie
     * @since : Create in 2018-05-21
     */
    @DeleteMapping("/deleteUserById")
    @ApiOperation(value="/deleteUserById", notes="通过id删除User")
    public JSONResult<User> deleteUserById(@ApiParam(name="id",value="UserID",required=true)Long id) {
            JSONResult<User> resJson = new JSONResult<>();
            try{
                resJson.setSuccess(userService.deleteById(id));
            }catch (Exception e) {
                resJson.setSuccess(false);
                resJson.setMessage("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 通过id更新User
     * ---------------------------------
     * @author : HoldDie
     * @since : Create in 2018-05-21
     */
    @PutMapping("/updateUserById")
    @ApiOperation(value="/updateUserById", notes="通过id更新User")
    public JSONResult<User> updateUserById(@ApiParam(name="User",value="User 实体类")User param) {
            JSONResult<User> resJson = new JSONResult<>();
            try{
                resJson.setSuccess(userService.updateById(param));
            }catch (Exception e) {
                resJson.setSuccess(false);
                resJson.setMessage("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }

    /**
     * @description : 添加User
     * ---------------------------------
     * @author : HoldDie
     * @since : Create in 2018-05-21
     */
	@PutMapping("/addUser")
    @ApiOperation(value="/addUser", notes="添加User")
    public JSONResult<User> addUser(@ApiParam(name="User",value="User 实体类")User param) {
            JSONResult<User> resJson = new JSONResult<>();
            try{
                resJson.setSuccess(userService.insert(param));
            }catch (Exception e) {
                resJson.setSuccess(false);
                resJson.setMessage("异常信息:"+e.getClass().getName());
                logger.info("异常信息:{}",e.getMessage());
            }
            return resJson;
    }
}
