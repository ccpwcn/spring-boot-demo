package cn.srwasu.commons.api;

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

    private int code;
    private String msg;
    private T res;

    private ApiRes() {
        this(ResConst.FORBIDDEN);
    }

    private ApiRes(ResConst rc) {
        this(rc, null);
    }

    private ApiRes(ResConst rc, T res) {
        this.code = rc.code;
        this.msg = rc.msg;
        this.res = res;
    }

    public static <T> ApiRes<T> ok() {
        return ok(ResConst.SUCCESS, null);
    }

    public static <T> ApiRes<T> ok(T t) {
        return ok(ResConst.SUCCESS, t);
    }

    public static <T> ApiRes<T> ok(ResConst rc) {
        return ok(rc, null);
    }

    public static <T> ApiRes<T> ok(ResConst rc, T res) {
        return new ApiRes<>(rc, res);
    }

    public static <T> ApiRes<T> fail(ResConst rc) {
        return new ApiRes<>(rc);
    }
}
