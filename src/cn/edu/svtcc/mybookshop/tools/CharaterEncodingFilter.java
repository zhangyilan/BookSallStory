package cn.edu.svtcc.mybookshop.tools;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName="charFiler",
		urlPatterns={"/*"},
		initParams={
				@WebInitParam(name="encoding",value="UTF-8")
				}
		)
public class CharaterEncodingFilter implements Filter {
	
	String encoding="";
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding(encoding);
		chain.doFilter(req, resp);
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//读取web.xmi中的初始参数
		encoding=config.getInitParameter("encoding");
	}

}
