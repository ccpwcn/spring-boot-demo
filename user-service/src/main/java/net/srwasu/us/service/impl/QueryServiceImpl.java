package net.srwasu.us.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.srwasu.us.service.QueryService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <h3>功能描述</h3>
 * <p>功能详解</p>
 *
 * @author lidawei
 * @version 2.0
 * @date 2021/2/25 11:43
 */
@Slf4j
@Service
@CacheConfig(cacheNames = {"query-res", "demo"})
public class QueryServiceImpl implements QueryService {
    @Override
    @Cacheable(unless = "#result.length() > 20")
    public String query(String keyword) {
        try {
            Thread.sleep(3000L);
            return "result of " + keyword;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
