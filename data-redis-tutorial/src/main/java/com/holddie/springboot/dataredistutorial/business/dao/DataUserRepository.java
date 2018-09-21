package com.holddie.springboot.dataredistutorial.business.dao;

import com.holddie.springboot.dataredistutorial.business.entity.DataUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 数据处理层
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/7/31 11:38
 */
public interface DataUserRepository extends JpaRepository<DataUserEntity, Integer> {

}
