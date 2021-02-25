package net.srwasu.us.service;

/**
 * <h3>查询服务接口</h3>
 * <p>查询服务</p>
 *
 * @author lidawei
 * @version 2.0
 * @date 2021/2/25 11:42
 */
public interface QueryService {
    /**
     * 查询
     * @param keyword 查询词
     * @return 返回查询数据，可能来自缓存，也可能不是
     */
    String query(String keyword);
}
