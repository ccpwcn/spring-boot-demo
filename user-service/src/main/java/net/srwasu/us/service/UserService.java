package net.srwasu.us.service;

import cn.srwasu.commons.api.ApiRes;
import net.srwasu.us.vo.UserUpdateVo;

/**
 * <h3>功能描述</h3>
 * <p>功能详解</p>
 *
 * @author lidawei
 * @version 2.0
 * @date 2021/2/26 17:12
 */
public interface UserService {
    /**
     * 按ID更新用户信息
     * @param vo 视图/接口对象模型
     * @return 返回操作状态，1代表成功，0代表失败
     */
    ApiRes<Integer> updateById(UserUpdateVo vo);
}
