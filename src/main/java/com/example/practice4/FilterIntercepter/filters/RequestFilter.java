package com.example.practice4.FilterIntercepter.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = {"/api/*"})
public class RequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter 사용");
        chain.doFilter(request, response);
        System.out.println("doFilter 종료");
    }
}
