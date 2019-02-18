package com.zhutao.ioc.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * 自定义扫描过滤器filter
 * @Author: zhutao
 * @Date: 2019/2/18 9:10
 * @Version 1.0
 */
public class MyFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        // 当前类注解信息
        AnnotatedTypeMetadata annotatedTypeMetadata = metadataReader.getAnnotationMetadata();

        // 当前正在扫描的类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        // 当前类的资源信息
        Resource resource = metadataReader.getResource();

        System.out.println(classMetadata.getClassName());

        return false;
    }
}
