package cn.srwasu.commons.utils;

import java.lang.reflect.Method;

/**
 * <h3>功能描述</h3>
 * <p>功能详解</p>
 *
 * @author lidawei
 * @version 2.0
 * @date 2021/2/25 15:16
 */
public interface KeyGenerator {
    /**
     * 主键生成器
     * @param target 目标实例
     * @param method 方法
     * @param params 参数
     * @return 返回实例
     */
    public Object generate(Object target, Method method, Object... params);
}
