package com.cell.user.filter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RequestParamaterFilter implements Filter {

	private static Field requestField;
	private static Field parametersParsedField;
	private static Field coyoteRequestField;
	private static Field parametersField;
	private static Field hashTabArrField;

	@Override
	public void init(FilterConfig paramFilterConfig) throws ServletException {
		try {
			Class clazz = Class
					.forName("org.apache.catalina.connector.RequestFacade");
			requestField = clazz.getDeclaredField("request");
			requestField.setAccessible(true);
			parametersParsedField = requestField.getType().getDeclaredField(
					"parametersParsed");
			parametersParsedField.setAccessible(true);
			coyoteRequestField = requestField.getType().getDeclaredField(
					"coyoteRequest");
			coyoteRequestField.setAccessible(true);
			parametersField = coyoteRequestField.getType().getDeclaredField(
					"parameters");
			parametersField.setAccessible(true);
			hashTabArrField = parametersField.getType().getDeclaredField(
					"paramHashStringArray");
			hashTabArrField.setAccessible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		Map<String, String[]> map = getRequestMap(request);
		if (map != null) {
			map.put("RMB", new String[] { "fuck you!" });
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	private Map<String, String[]> getRequestMap(ServletRequest request) {
		try {
			Object innerRequest = requestField.get(request);
			parametersParsedField.setBoolean(innerRequest, true);
			Object coyoteRequestObject = coyoteRequestField.get(innerRequest);
			Object parameterObject = parametersField.get(coyoteRequestObject);
			return (Map<String, String[]>) hashTabArrField.get(parameterObject);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return Collections.emptyMap();
		}
	}
}
