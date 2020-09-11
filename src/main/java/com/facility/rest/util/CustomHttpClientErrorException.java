package com.facility.rest.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClientException;


public class CustomHttpClientErrorException extends RestClientException {

	private static final long serialVersionUID = -5807494703720513267L;

	private static final String DEFAULT_CHARSET = "ISO-8859-1";


	private final HttpStatus statusCode;

	private final String statusText;

	private final String exceptionText;

	private final byte[] responseBody;

	private final HttpHeaders responseHeaders;

	private final String responseCharset;


	/**
	 * Construct a new instance of {@code HttpStatusCodeException} based on an
	 * {@link HttpStatus}.
	 * @param statusCode the status code
	 */
	public CustomHttpClientErrorException(HttpStatus statusCode) {
		this(statusCode, statusCode.name(), null, null, null);
	}

	/**
	 * Construct a new instance of {@code HttpStatusCodeException} based on an
	 * {@link HttpStatus} and status text.
	 * @param statusCode the status code
	 * @param statusText the status text
	 */
	public CustomHttpClientErrorException(HttpStatus statusCode, String statusText, String exceptionText) {
		this(statusCode, statusText, exceptionText, null, null, null);
	}

	/**
	 * Construct a new instance of {@code HttpStatusCodeException} based on an
	 * {@link HttpStatus}, status text, and response body content.
	 * @param statusCode the status code
	 * @param statusText the status text
	 * @param responseBody the response body content, may be {@code null}
	 * @param responseCharset the response body charset, may be {@code null}
	 * @since 3.0.5
	 */
	public CustomHttpClientErrorException(HttpStatus statusCode, String statusText, 
			String exceptionText, byte[] responseBody, Charset responseCharset) {

		this(statusCode, statusText, exceptionText, null, responseBody, responseCharset);
	}

	/**
	 * Construct a new instance of {@code HttpStatusCodeException} based on an
	 * {@link HttpStatus}, status text, and response body content.
	 * @param statusCode the status code
	 * @param statusText the status text
	 * @param exceptionText the exception text
	 * @param responseHeaders the response headers, may be {@code null}
	 * @param responseBody the response body content, may be {@code null}
	 * @param responseCharset the response body charset, may be {@code null}
	 * @since 3.1.2
	 */
	public CustomHttpClientErrorException(HttpStatus statusCode, String statusText,
			String exceptionText, HttpHeaders responseHeaders, byte[] responseBody, Charset responseCharset) {

		super(statusText);
		this.statusCode = statusCode;
		this.statusText = statusText;
		this.exceptionText = exceptionText;
		this.responseHeaders = responseHeaders;
		this.responseBody = responseBody != null ? responseBody : new byte[0];
		this.responseCharset = responseCharset != null ? responseCharset.name() : DEFAULT_CHARSET;
	}


	/**
	 * Return the HTTP status code.
	 */
	public HttpStatus getStatusCode() {
		return this.statusCode;
	}

	/**
	 * Return the HTTP status text.
	 */
	public String getStatusText() {
		return this.statusText;
	}

	/**
	 * Return the HTTP status text.
	 */
	public String getExceptionText() {
		return this.exceptionText;
	}

	/**
	 * Return the HTTP response headers.
	 * @since 3.1.2
	 */
	public HttpHeaders getResponseHeaders() {
		return this.responseHeaders;
	}

	/**
	 * Return the response body as a byte array.
	 * @since 3.0.5
	 */
	public byte[] getResponseBodyAsByteArray() {
		return this.responseBody;
	}

	/**
	 * Return the response body as a string.
	 * @since 3.0.5
	 */
	public String getResponseBodyAsString() {
		try {
			return new String(this.responseBody, this.responseCharset);
		}
		catch (UnsupportedEncodingException ex) {
			// should not occur
			throw new IllegalStateException(ex);
		}
	}

}

