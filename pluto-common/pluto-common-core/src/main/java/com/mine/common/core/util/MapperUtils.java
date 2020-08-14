package com.mine.common.core.util;

import lombok.experimental.UtilityClass;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import ma.glasnost.orika.metadata.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * @ClassName MapperUtils
 * @Description 实体映射工具类
 * @Author Y
 * @Date 2019-12-26 20:12
 */
@UtilityClass
public class MapperUtils {

    public final MapperUtils INSTANCE = new MapperUtils();
    /**
     * 获取默认字段工厂
     */
    private MapperFactory MAPPER_FACTORY = getMapperFactory();
    /**
     * 默认字段实例
     */
    private final MapperFacade MAPPER_FACADE = MAPPER_FACTORY.getMapperFacade();

    private Map<String, MapperFacade> CACHE_MAPPER_FACADE_MAP = new HashMap<>();

    /**
     * 映射实体（默认字段）
     * 这种映射就是dto字段名称和实体对象DO之间字段名称一致
     * @param toClass 映射类对象 dto对象
     * @param data   数据（对象）do对象
     * @return 映射类对象
     */
    public <E, T> E map(Class<E> toClass, T data) {
        return MAPPER_FACADE.map(data, toClass);
    }

    /**
     * 映射实体（自定义配置）
     * @param toClass   映射类对象 dto对象
     * @param data     数据（对象）do对象
     * @param configMap 自定义配置,dto与do对象字段名称不一致时配置的映射 {dataAttr, toClassAttr}
     * @return 映射类对象
     */
    public <E, T> E map(Class<E> toClass, T data, Map<String, String> configMap) {
        MapperFacade mapperFacade = getMapperFacade(toClass, data.getClass(), configMap);
        return mapperFacade.map(data, toClass);
    }

    /**
     * 映射集合（默认字段）
     * 映射为集合的形式
     * @param toClass 映射类对象 dto对象
     * @param data    数据（集合）do对象
     * @return 映射类对象
     */
    public <E, T> List<E> mapAsList(Class<E> toClass, Collection<T> data) {
        return MAPPER_FACADE.mapAsList(data, toClass);
    }

    /**
     * 获取自定义映射
     *
     * @param toClass   映射类
     * @param dataClass 数据映射类
     * @param configMap 自定义配置
     * @return 映射类对象
     */
    private <E, T> MapperFacade getMapperFacade(Class<E> toClass, Class<T> dataClass, Map<String, String> configMap) {
        String mapKey = dataClass.getCanonicalName() + "_" + toClass.getCanonicalName();
        MapperFacade mapperFacade = CACHE_MAPPER_FACADE_MAP.get(mapKey);
        if (Objects.isNull(mapperFacade)) {
            MapperFactory factory = new DefaultMapperFactory.Builder().build();
            ClassMapBuilder classMapBuilder = factory.classMap(dataClass, toClass);
            configMap.forEach(classMapBuilder::field);
            classMapBuilder.byDefault().register();
            mapperFacade = factory.getMapperFacade();
            CACHE_MAPPER_FACADE_MAP.put(mapKey, mapperFacade);
        }
        return mapperFacade;
    }

    private MapperFactory getMapperFactory(){
        DefaultMapperFactory factory = new DefaultMapperFactory.Builder().build();
        factory.getConverterFactory().registerConverter(new LocalDateTimeConverter());
        factory.getConverterFactory().registerConverter(new LocalDateConverter());
        factory.getConverterFactory().registerConverter(new LocalTimeConverter());
        return factory;
    }

    private class LocalDateTimeConverter extends BidirectionalConverter<LocalDateTime, LocalDateTime> {
        @Override
        public LocalDateTime convertTo(LocalDateTime source, Type<LocalDateTime> destinationType) {
            return LocalDateTime.from(source);
        }
        @Override
        public LocalDateTime convertFrom(LocalDateTime source, Type<LocalDateTime> destinationType) {
            return LocalDateTime.from(source);
        }
    }
    private class LocalDateConverter extends BidirectionalConverter<LocalDate, LocalDate> {
        @Override
        public LocalDate convertTo(LocalDate source, Type<LocalDate> destinationType) {
            return LocalDate.from(source);
        }
        @Override
        public LocalDate convertFrom(LocalDate source, Type<LocalDate> destinationType) {
            return LocalDate.from(source);
        }
    }
    private class LocalTimeConverter extends BidirectionalConverter<LocalTime, LocalTime> {
        @Override
        public LocalTime convertTo(LocalTime source, Type<LocalTime> destinationType) {
            return LocalTime.from(source);
        }
        @Override
        public LocalTime convertFrom(LocalTime source, Type<LocalTime> destinationType) {
            return LocalTime.from(source);
        }
    }
}
