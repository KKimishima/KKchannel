package com.github.KKimishima.Filter;

import com.github.KKimishima.model.beans.LoginUser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/Main/*")
public class LoginFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws ServletException, IOException {
    HttpSession session = ((HttpServletRequest)request).getSession();
    LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");
    if (loginUser == null){
      session.removeAttribute("loginUser");
      ((HttpServletResponse)response).sendRedirect("/KKchannel/Login");
      return;
    }
    chain.doFilter(request,response);
  }

  @Override
  public void destroy() {

  }
}
