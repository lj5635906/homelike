package com.homelike.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * Token验证Filter,前置过滤器
 *
 * @author roger
 * @email 190642964@qq.com
 * @create 2018-04-02 15:10
 **/
//@Component
public class TokenFilter extends ZuulFilter {

    /**
     * token 名称
     */
    private final static String TOKEN = "token";

    /**
     * 过滤器类型
     *
     * @return pre 前置过滤器
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 过滤器执行顺序
     *
     * @return 推荐顺序
     */
    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 实现逻辑
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        // 从header中获取token
        String token = request.getHeader(TOKEN);
        if (StringUtils.isEmpty(token)) {
            // 从参数里边获取token
            token = request.getParameter(TOKEN);
            if (StringUtils.isEmpty(token)) {
//                requestContext.setSendZuulResponse(false);
//                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }
        return null;
    }
}
