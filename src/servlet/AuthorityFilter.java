package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class AuthorityFilter implements Filter{
public void destroy()
{
	

}
public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain)
throws IOException, ServletException{
HttpServletRequest request=(HttpServletRequest)req;
HttpServletResponse response=(HttpServletResponse)resp;
HttpSession session=request.getSession();
String superuser=(String)session.getAttribute("superuser");

if(superuser==null)
{
response.sendRedirect(request.getContextPath()+"/authority.html");
}else
{
if(superuser.equals("3"))
{
chain.doFilter(req,resp);
}else{
if(superuser.equals("3"))
{
chain.doFilter(req,resp);
}else
{
response.sendRedirect(request.getContextPath()+"/ok.html");
}
}
}
}
public void init(FilterConfig arg0) throws ServletException
{
	
}

}


