package com.kvr;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class SessionPostFilter extends ZuulFilter {
	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpSession session = RequestContext.getCurrentContext().getRequest().getSession();
		HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();
		String[] paths = httpServletRequest.getServletPath().split("/");
		Map<String, String> map = new HashMap<>();
		RequestContext.getCurrentContext().getZuulResponseHeaders().stream().filter(p -> {
			return p.first().equalsIgnoreCase("Content-Type");
		}).findAny().ifPresent(p -> {
			if (p.second().equalsIgnoreCase("application/xml")) {
				map.put(paths[paths.length - 1], "XML");
				session.setAttribute("prevEndpoint", map);
			} else {
				map.put(paths[paths.length - 1], "JSON");
				session.setAttribute("prevEndpoint", map);
			}
		});
		return null;
	}
}
