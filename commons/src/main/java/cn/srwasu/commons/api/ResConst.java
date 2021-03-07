package cn.srwasu.commons.api;

public enum ResConst {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    /**
     * 无权限
     */
    FORBIDDEN(403, "暂无权限"),
    /**
     * 未找到
     */
    NOT_FOUND(404, "未找到"),

    /**
     * 先决条件不满足
     */
    CONFLICT(409, "请求存在冲突"),

    /**
     * 先决条件不满足
     */
    PRECONDITION_FAIL(412, "先决条件不满足"),
    /**
     * 内部错误
     */
    INTERNAL_ERROR(500, "内部错误");

    int code;
    String msg;
    ResConst(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
