package net.srwasu.us.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author lidawei
 * @Date 2020/12/26 9:19
 */
@Configuration
@ConfigurationProperties("password")
public class PasswordConf {
    private String saltType;
    private int minLen;
    private int maxLen;

    public String getSaltType() {
        return saltType;
    }

    public void setSaltType(String saltType) {
        this.saltType = saltType;
    }

    public int getMinLen() {
        return minLen;
    }

    public void setMinLen(int minLen) {
        this.minLen = minLen;
    }

    public int getMaxLen() {
        return maxLen;
    }

    public void setMaxLen(int maxLen) {
        this.maxLen = maxLen;
    }
}
