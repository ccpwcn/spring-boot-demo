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
