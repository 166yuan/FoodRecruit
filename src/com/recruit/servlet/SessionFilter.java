package com.recruit.servlet;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2015/3/18.
 */
public class SessionFilter extends OncePerRequestFilter{
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 过滤的uri
        String[] notFilter = new String[] { "user/home","mana", "exper","publish","myPublishExperiment","addExper","delete","employ","scoreExper","myAttend"
        ,"Profile","upload","addfeedback","edit","compet","score"};

        // 请求的uri
        String uri = request.getRequestURI();

            // 是否过滤
            boolean doFilter = false;
            for (String s : notFilter) {
                if (uri.indexOf(s) != -1) {
                    // 如果uri中包含过滤的uri，则进行过滤
                    doFilter = true;
                    break;
                }
            }
            if (doFilter) {
                // 执行过滤
                // 从session中获取登录者实体
                Object obj = request.getSession().getAttribute("userId");
                if (null == obj) {
                    // 如果session中不存在登录者实体，则弹出框提示重新登录
                    // 设置request和response的字符集，防止乱码
                    request.setCharacterEncoding("UTF-8");
                    response.setCharacterEncoding("UTF-8");
                    PrintWriter out = response.getWriter();
                    String loginPage = "/user/login";
                    StringBuilder builder = new StringBuilder();
                    builder.append("<script type=\"text/javascript\">");
                    builder.append("alert('please login again!');");
                    builder.append("window.top.location.href='");
                    builder.append(loginPage);
                    builder.append("';");
                    builder.append("</script>");
                    out.print(builder.toString());
                } else {
                    // 如果session中存在登录者实体，则继续
                    filterChain.doFilter(request, response);
                }
            } else {
                // 如果不执行过滤，则继续
                filterChain.doFilter(request, response);
            }

    }
}
