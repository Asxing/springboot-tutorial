package com.holddie.springboot.mybatis.config.mybatis;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * 自定义公共处理字段
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/18 18:23
 */
public class MyBatisMetaObjectHandler extends MetaObjectHandler {

    /**
     * 公共插入数据时，填充信息
     * 1、创建时间
     * 2、创建人
     * @param metaObject 操作的对象
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/18 18:26
     */
    @Override
    public void insertFill(MetaObject metaObject) {

        System.out.println(234);
    }

    /**
     * 公共更新数据时，填充信息
     * 1、修改时间
     * 2、修改人
     * @param metaObject 操作对象
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/18 18:27
     */
    @Override
    public void updateFill(MetaObject metaObject) {

        System.out.println(123);

    }

    public MyBatisMetaObjectHandler() {
        super();
    }

    @Override
    public MetaObjectHandler setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject) {
        return super.setFieldValByName(fieldName, fieldVal, metaObject);
    }

    @Override
    public Object getFieldValByName(String fieldName, MetaObject metaObject) {
        return super.getFieldValByName(fieldName, metaObject);
    }

    @Override
    public boolean openInsertFill() {
        return super.openInsertFill();
    }

    @Override
    public boolean openUpdateFill() {
        return super.openUpdateFill();
    }
}
