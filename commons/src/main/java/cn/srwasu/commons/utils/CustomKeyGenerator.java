package cn.srwasu.commons.utils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * <h3>常规键生成器</h3>
 * <p>一般的通用方法</p>
 *
 * @author lidawei
 * @version 2.0
 * @date 2021/2/25 15:17
 */
public class CustomKeyGenerator implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) {
        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();
        String paramHash = String.valueOf(Arrays.toString(params).hashCode());
        return new StringJoiner("_").add(className).add(methodName)
                .add(paramHash).toString();
    }
}
