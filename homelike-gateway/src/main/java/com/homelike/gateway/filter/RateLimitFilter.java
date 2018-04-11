package com.homelike.gateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.homelike.common.core.exception.RateLimitException;
import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * 限流过滤器  在所有pre过滤器之前执行,优先级最高
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-02 15:34
 **/
@Component
public class RateLimitFilter extends ZuulFilter {

    /**
     * 令牌桶算法，每秒钟往令牌桶中放100个请求
     */
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        // 从令牌桶中获取一个令牌
        boolean flag = RATE_LIMITER.tryAcquire();
        if (!flag){
            throw new RateLimitException();
        }
        return null;
    }
}
