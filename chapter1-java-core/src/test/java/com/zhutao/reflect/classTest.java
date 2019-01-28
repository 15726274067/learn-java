package com.zhutao.reflect;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

/**
 * @Author: zhutao
 * @Date: 2019/1/25 17:51
 * @Version 1.0
 */
public class classTest {
    public void getClass1(){

        Class<?> cl = "".getClass();

    }

    public void getClass2() throws ClassNotFoundException, IntrospectionException {
        Class<?> cl = Class.forName("java.util.Arrays");
        cl.getClassLoader();

        BeanInfo beanInfo = Introspector.getBeanInfo(cl);
        beanInfo.getPropertyDescriptors();
    }

    private void getClass3(){
        Class<?> cl = java.util.Arrays.class;

    }


}
