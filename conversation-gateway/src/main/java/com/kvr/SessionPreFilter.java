package com.kvr;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.kvr.model.ProtocolNode;
import com.kvr.model.ProtocolTransition;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class SessionPreFilter extends ZuulFilter {

	@Autowired
	private CoordinatioProtocol coordinationProtocol;

	@Override
	public String filterType() {
		return "pre";
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
		validateRequestByCoordinationRule(RequestContext.getCurrentContext());
		return null;
	}

	private void validateRequestByCoordinationRule(RequestContext requestContext) throws ZuulException {
		HttpSession session = requestContext.getRequest().getSession();
		HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();
		String[] paths = httpServletRequest.getServletPath().split("/");
		String currentEndpointName = paths[paths.length - 1];
		Object object = session.getAttribute("prevEndpoint");
		List<ProtocolNode> protocolNodes = coordinationProtocol.getProtocolList();
		if (Objects.nonNull(object)) {
			@SuppressWarnings("unchecked")
			Map<String, String> previousEndpointDetailMap = (Map<String, String>) object;
			Entry<String, String> entry = previousEndpointDetailMap.entrySet().stream().findFirst().get();
			String previouseEndpointName = entry.getKey();
			String previousEndpointResponseType = entry.getValue();
			ProtocolNode protocolNode = protocolNodes.stream().filter(p -> {
				return p.getName().equalsIgnoreCase(previouseEndpointName);
			}).findFirst().get();
			if (protocolNode.getTransitions().size() == 1) {
				ProtocolTransition protocolTransition = protocolNode.getTransitions().get(0);
				if (!protocolTransition.getNextNodeName().equalsIgnoreCase(currentEndpointName)) {
					throw new ZuulException("violates the coordination protocol", 500,
							"violates the coordination protocol");
				}
			} else {
				Optional<ProtocolTransition> protocolTransition = protocolNode.getTransitions().stream()
						.filter(p -> p.getType().equalsIgnoreCase(previousEndpointResponseType)).findFirst();
				if (protocolTransition.isPresent()) {
					if (!protocolTransition.get().getNextNodeName().equalsIgnoreCase(currentEndpointName)) {
						throw new ZuulException("violates the coordination protocol", 500,
								"violates the coordination protocol");
					}
				} else {
					throw new ZuulException("violates the coordination protocol", 500,
							"violates the coordination protocol");
				}
			}
		}
	}
}
