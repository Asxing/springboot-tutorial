package com.holddie.springboot.dataredistutorial.config;


import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;

import javax.annotation.Nullable;
import java.util.Arrays;

class CacheKeyConversionService implements ConversionService {
    @Override
    public boolean canConvert(@Nullable Class<?> sourceType, Class<?> targetType) {
        return true;
    }

    @Override
    public boolean canConvert(@Nullable TypeDescriptor sourceType, TypeDescriptor targetType) {
        return true;
    }

    @Nullable
    @Override
    public <T> T convert(@Nullable Object source, Class<T> targetType) {
        return (T) convert(source);
    }

    @Nullable
    @Override
    public Object convert(@Nullable Object source, @Nullable TypeDescriptor sourceType, TypeDescriptor targetType) {
        return convert(source);
    }

    private Object convert(Object source) {
        if (source instanceof CacheHashCode) {
            return ((CacheHashCode) source).hashString();
        }
        return CacheHashCode.of(source).hashString();
    }
}

class CacheHashCode {
    private Object[] params;
    private int code;

    private CacheHashCode(Object[] params) {
        this.params = params;
        this.code = Arrays.deepHashCode(params);
    }

    static CacheHashCode of(Object object) {
        return new CacheHashCode(isArray(object) ? toObjectArray(object) : new Object[]{object});
    }

    @Override
    public int hashCode() {
        return code;
    }

    String hashString() {
        return code + "";
    }

    @Override
    public String toString() {
        return "CacheHashCode{" +
                "params=" + Arrays.toString(params) +
                ", code=" + code +
                '}';
    }

    private static Object[] toObjectArray(Object obj) {
        return null;
    }

    private static boolean isArray(Object obj) {
        if (null == obj) {
            return false;
        }
//        反射 获得类型
        return obj.getClass().isArray();
    }
}