package util.filter;

import javax.servlet.*;
import java.io.IOException;


public class CharsetFilter implements Filter
{
 private String encoding;

 public void init(FilterConfig config) throws ServletException
 {
  encoding = config.getInitParameter("requestEncoding");

  if( encoding==null ) encoding="UTF-8";
 }

 public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
 throws IOException, ServletException
 {
  request.setCharacterEncoding(encoding);
  next.doFilter(request, response);
 }

 public void destroy(){}
}

