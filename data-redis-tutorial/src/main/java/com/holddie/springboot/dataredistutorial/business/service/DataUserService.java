package com.holddie.springboot.dataredistutorial.business.service;

import com.holddie.springboot.dataredistutorial.business.entity.DataUserEntity;

import java.util.List;

/**
 * 测试接口
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/7/31 11:35
 */
public interface DataUserService {
    /**
     * 查找所有用户
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/7/31 11:36
     */
    List<DataUserEntity> findAll();
}
