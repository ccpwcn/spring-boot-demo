package net.srwasu.us.service.impl;

import cn.srwasu.commons.api.ApiRes;
import cn.srwasu.commons.api.ResConst;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import net.srwasu.us.service.UserService;
import net.srwasu.us.vo.UserUpdateVo;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <h3>功能描述</h3>
 * <p>功能详解</p>
 *
 * @author lidawei
 * @version 2.0
 * @date 2021/2/26 17:17
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RedissonClient redissonClient;

    @Override
    public ApiRes<Integer> updateById(UserUpdateVo vo) {
        RLock lock = redissonClient.getLock("net.srwasu.us.service.impl.UserServiceImpl.updateById__" + vo.getUserId());
        boolean locked = lock.isLocked();
        if (locked) {
            return ApiRes.fail(ResConst.CONFLICT);
        } else {
            try {
                if (lock.tryLock()) {
                    Thread.sleep(3000);
                    return ApiRes.ok();
                } else {
                    return ApiRes.fail(ResConst.PRECONDITION_FAIL);
                }
            } catch (Exception e) {
                log.error("updateById exception, request param:{}", JSON.toJSONString(vo), e);
                return ApiRes.fail(ResConst.INTERNAL_ERROR);
            } finally {
                lock.unlock();
            }
        }
    }
}
