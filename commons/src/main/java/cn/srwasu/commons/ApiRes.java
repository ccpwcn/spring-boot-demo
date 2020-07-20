package cn.srwasu.commons;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lidawei
 * @Description 接口通用信息封装
 * @Date 2020/7/20 17:55
 */
@Data
public class ApiRes<T> implements Serializable {
    private static final long serialVersionUID = 1023920394L;

    private Integer code;
    private String msg;
    private T res;
}
