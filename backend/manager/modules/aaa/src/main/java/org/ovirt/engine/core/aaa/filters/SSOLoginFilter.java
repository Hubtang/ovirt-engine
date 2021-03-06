package org.ovirt.engine.core.aaa.filters;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.ovirt.engine.core.common.constants.SessionConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SSOLoginFilter implements Filter {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private String loginUrl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        loginUrl = filterConfig.getInitParameter("login-url");
        if (loginUrl == null) {
            throw new RuntimeException("No login-url init parameter specified for SSOLoginFilter.");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        log.debug("Entered SSOLoginFilter");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if (req.getSession(false) == null || req.getSession(false).getAttribute(FiltersHelper.Constants.LOGOUT_INPROGRESS) == null) {
            StringBuffer requestURL = req.getRequestURL();
            if (StringUtils.isNotEmpty(req.getQueryString())) {
                requestURL.append("?").append(req.getQueryString());
            }
            if (!FiltersHelper.isAuthenticated(req) || !FiltersHelper.isSessionValid((HttpServletRequest) request)) {
                log.debug("Redirecting to {}{}&app_url={}", req.getServletContext().getContextPath(), loginUrl, URLEncoder.encode(requestURL.toString(), "UTF-8"));
                res.sendRedirect(String.format("%s%s&app_url=%s", req.getServletContext().getContextPath(), loginUrl, URLEncoder.encode(requestURL.toString(), "UTF-8")));
            } else {
                log.debug("Already logged in, executing next filter in chain.");
                res.addHeader("OVIRT-SSO-TOKEN",
                        URLEncoder.encode((String) ((HttpServletRequest) request).getSession(true).getAttribute(SessionConstants.HTTP_SESSION_ENGINE_SESSION_ID_KEY), "UTF-8"));
                chain.doFilter(request, response);
            }
        }
        log.debug("Exiting SSOLoginFilter");
    }

    @Override
    public void destroy() {
    }

}
