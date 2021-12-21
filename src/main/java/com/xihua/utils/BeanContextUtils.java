package com.xihua.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Author:   lxs
 * Date:     2021/9/30 12:12
 * Description: Bean工厂工具类
 */
@Component
public class BeanContextUtils implements ApplicationContextAware {

    /**
     * 上下文实例对象
     */
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanContextUtils.applicationContext = applicationContext;
    }

    /**
     * 获取application上下文对象
     *
     * @return 上下文对象
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 通过name获取bean
     *
     * @param beanName 类名
     * @param <T>      泛型
     * @return 泛型
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName) {
        assertApplicationContext();
        return (T) getApplicationContext().getBean(beanName);
    }

    /**
     * 通过class获取bean
     *
     * @param requiredType 类.class
     * @param <T>          泛型
     * @return 泛型
     */
    public static <T> T getBean(Class<T> requiredType) {
        return (T) getApplicationContext().getBean(requiredType);
    }

    //断言applicationContext不为空
    private static void assertApplicationContext() {
        if (BeanContextUtils.applicationContext == null) {
            throw new RuntimeException("ApplicationContext属性为null，请检查是否注入了SpringContextHolder");
        }
    }
}
