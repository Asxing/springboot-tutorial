package com.holddie.springboot.dataredistutorial.business.service;

import com.holddie.springboot.dataredistutorial.business.dao.DataUserRepository;
import com.holddie.springboot.dataredistutorial.business.entity.DataUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试查询用户
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/7/31 11:37
 */
@Service
public class DataUserServiceImpl implements DataUserService {

    @Autowired
    private DataUserRepository dataUserRepository;

    /**
     * 查找所有用户
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/7/31 11:36
     */
    @Override
    public List<DataUserEntity> findAll() {
        return dataUserRepository.findAll();
    }
}
