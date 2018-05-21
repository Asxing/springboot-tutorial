package com.holddie.springboot.mybatis.rest.dao;

import com.holddie.springboot.mybatis.rest.entity.User;
import com.holddie.springboot.mybatis.common.base.BaseDao;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;

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
 * @description User Mapper 接口
 * @since 2018-05-21
 */
@Repository
public interface UserMapper extends BaseDao<User> {

}