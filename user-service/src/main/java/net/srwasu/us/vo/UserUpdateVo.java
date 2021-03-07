package net.srwasu.us.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <h3>功能描述</h3>
 * <p>功能详解</p>
 *
 * @author lidawei
 * @version 2.0
 * @date 2021/2/26 17:15
 */
@Data
@NoArgsConstructor
public class UserUpdateVo implements Serializable {
    private static final long serialVersionUID = 8233545759845061143L;
    private Integer userId;
    private String nickname;
    private String mobile;
}
