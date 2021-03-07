package net.srwasu.us.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h3>功能描述</h3>
 * <p>功能详解</p>
 *
 * @author lidawei
 * @version 2.0
 * @date 2021/2/26 17:13
 */
@Data
@NoArgsConstructor
public class UserInfo {
    /**
     * ID
     */
    private Integer userId;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 身份证号
     */
    private String idNum;
}
