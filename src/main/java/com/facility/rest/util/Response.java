package com.facility.rest.util;

import java.util.Locale;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class Response<T>{
	
	private final Long timestamp;
	private final Locale locale;
	private final Integer status;
	private final String message;
	private final String error;
	private final String exception;
	private final T responseBody;

	public Response() {
		this(null);
	}

	/**
	 * @param statusCode
	 */
	public Response(T responseBody) {
		this(responseBody, null);
	}

	/**
	 * @param responseBody
	 * @param statusCode
	 */
	public Response(T responseBody, HttpSession session) {
		this(responseBody, session, null);
	}

	/**
	 * @param responseBody
	 * @param statusCode
	 * @param statusMessage
	 */
	public Response(T responseBody, HttpSession session, HttpStatus httpStatus) {
		this(responseBody, session, httpStatus, null);
	}

	/**
	 * @param responseBody
	 * @param statusCode
	 * @param statusMessage
	 * @param exceptionMessage
	 */
	public Response(T responseBody, HttpSession session, HttpStatus httpStatus, String message) {
		this(responseBody, session, httpStatus, message, null);
	}

	/**
	 * @param responseBody
	 * @param statusCode
	 * @param statusMessage
	 * @param exceptionMessage
	 */
	public Response(T responseBody, HttpSession session, HttpStatus httpStatus, String message, String error) {
		this(responseBody, session, httpStatus, message, error, null);
	}

	/**
	 * @param responseBody
	 * @param statusCode
	 * @param statusMessage
	 * @param exceptionMessage
	 */
	public Response(T responseBody, HttpSession session, HttpStatus httpStatus, String message, String error, String exception) {
		
		this.timestamp = System.currentTimeMillis();
		// SESSION_USER_LOCALE is set when user logs in. This is used for localization purpose.
		this.locale = (session != null) ? (Locale) session.getAttribute("SESSION_USER_LOCALE") : Locale.ENGLISH;
		this.status = (httpStatus != null) ? httpStatus.value() : HttpStatus.OK.value();
		this.message = (message != null) ? message : "OK";
		this.error = error;
		this.exception = exception;
		this.responseBody = responseBody;
	}

	/**
	 */
	public ResponseEntity<Response<T>> responseBuilder() {
		ResponseEntity<Response<T>> responseEntity = new ResponseEntity<Response<T>>(this, HttpStatus.valueOf(this.status));
		return responseEntity;
	}

	/**
	 * @return the timestamp
	 */
	public Long getTimestamp() {
		return timestamp;
	}

	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @return the exception
	 */
	public String getException() {
		return exception;
	}

	/**
	 * @return the responseBody
	 */
	public T getResponseBody() {
		return responseBody;
	}

	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return null;
		}
	}
}
