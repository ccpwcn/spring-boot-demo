package net.srwasu.us.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * <h3>Redisson</h3>
 * <p>加载配置</p>
 *
 * @author lidawei
 * @version 2.0
 * @date 2021/2/26 17:28
 */
@Configuration
public class RedissonConfig {
    @Autowired
    private RedissonProperties redissonProperties;

    @Bean
    public RedissonClient redisson() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress(redissonProperties.getAddress())
                .setDatabase(redissonProperties.getDatabase())
                .setIdleConnectionTimeout(redissonProperties.getIdleConnectionTimeout())
                .setPingConnectionInterval(redissonProperties.getPingConnectionInterval())
                .setConnectTimeout(redissonProperties.getConnectTimeout())
                .setTimeout(redissonProperties.getTimeout())
                .setRetryAttempts(redissonProperties.getRetryAttempts())
                .setRetryInterval(redissonProperties.getRetryInterval())
                .setConnectionMinimumIdleSize(redissonProperties.getConnectionMinimumIdleSize())
                .setConnectionPoolSize(redissonProperties.getConnectionPoolSize());
        return Redisson.create(config);
    }
}
