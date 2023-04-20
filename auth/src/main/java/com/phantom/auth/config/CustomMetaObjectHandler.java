package com.phantom.auth.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * MybatisPlus自动填充配置
 *
 * @author lei.tan
 * @version 1.0
 * @date 2023/4/19 23:08
 */
@Component
public class CustomMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入时自动填充
     *
     * @param metaObject 元数据对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

    /**
     * 更新时自动填充
     *
     * @param metaObject 元数据对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
