package net.srwasu.us.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * <h3>功能描述</h3>
 * <p>功能详解</p>
 *
 * @author lidawei
 * @version 2.0
 * @date 2021/2/26 17:46
 */
@Data
@NoArgsConstructor
@ToString
@Component
@ConfigurationProperties(prefix = "redisson")
public class RedissonProperties {
    private int idleConnectionTimeout;
    private int pingConnectionInterval;
    private int connectTimeout;
    private int timeout;
    private int retryAttempts;
    private int retryInterval;
    private int reconnectionTimeout;
    private int failedAttempts;
    private String password;
    private int subscriptionsPerConnection;
    private String clientName;
    private String address;
    private int subscriptionConnectionMinimumIdleSize;
    private int subscriptionConnectionPoolSize;
    private int connectionMinimumIdleSize;
    private int connectionPoolSize;
    private int database;
}
