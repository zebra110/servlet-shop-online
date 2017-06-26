package com.filter;

import javax.servlet.*;
import javax.servlet.http.*;
 
public class CharsetFilter implements Filter
{
  public void destroy() 
  {
     
  }
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
  {
    try
    {
      HttpServletRequest httpRequest = (HttpServletRequest)request;
      String method = httpRequest.getMethod().toLowerCase();
      if(method.equals("post"))
      {
        //�����post������������ֱ������charset����
        request.setCharacterEncoding("UTF-8");
      }
      else if(method.equals("get"))
      {
        //�����get����
        request.setCharacterEncoding("UTF-8");
        request = new HttpServletRequestWrapper((HttpServletRequest)request)
        {
          public String getParameter(String str)
          {
            try
            {
              return new String(super.getParameter(str).getBytes("iso-8859-1"),"GBK");
            }
            catch(Exception e)
            {
              return null;
            }
    
          }
        };
      }
       
      chain.doFilter(request, response);
    }
    catch(Exception e){}
  }
   
  public void init(FilterConfig filterConfig) 
  {
     
  }
}