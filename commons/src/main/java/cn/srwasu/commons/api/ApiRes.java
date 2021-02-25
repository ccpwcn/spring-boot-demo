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
        this(200, "ok");
    }

    private ApiRes(int code, String msg) {
        this(code, msg, null);
    }
    private ApiRes(int code, String msg, T res) {
        this.code = code;
        this.msg = msg;
        this.res = res;
    }

    public static <T> ApiRes<T> ok() {
        return ok(200, "ok", null);
    }

    public static <T> ApiRes<T> ok(T t) {
        return ok(200, "ok", t);
    }

    public static <T> ApiRes<T> ok(int code, String msg) {
        return ok(code, msg, null);
    }

    public static <T> ApiRes<T> ok(int code, String msg, T res) {
        return new ApiRes<>(code, msg, res);
    }

    public static <T> ApiRes<T> fail(int code, String msg) {
        return new ApiRes<>(code, msg);
    }
}
