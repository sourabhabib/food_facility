package com.facility.rest.conf;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionListener implements HttpSessionListener {

	static final Map<String, HttpSession> SESSION_USERS = new HashMap<String, HttpSession>();
	public static final String SESSION_USER_TOKEN = "token";
	public static final String SESSION_USER_KEY = "sessionUser";
	public static final String SESSION_USER_LOCALE = "locale";

	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		HttpSession session = sessionEvent.getSession();
		session.setMaxInactiveInterval(-1);
		SESSION_USERS.put(session.getId(), session);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		HttpSession session = sessionEvent.getSession();
		SESSION_USERS.remove(session.getId());
	}


	public static HttpSession getSession(String sessionId) {
		return SESSION_USERS.get(sessionId);
	}
}
