package com.shop.config;

import com.shop.exception.BaseErrorCause;
import com.shop.exception.FrontendBizException;
import com.shop.page.ApiData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.validation.ValidationException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 统一异常处理切面,处理所有异常 2022-05-20 增加异常告警
 */
@Slf4j
@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice implements ResponseBodyAdvice {

	/**
	 * 请求参数校验失败
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ApiData validExceptionHandler(MethodArgumentNotValidException e) {
		List<String> list = new ArrayList<>();
		if (!e.getBindingResult().getAllErrors().isEmpty()) {
			for (ObjectError error : e.getBindingResult().getAllErrors()) {
				list.add(error.getDefaultMessage().toString());
			}
		}

		String error = String.join(",", list);
		return ApiData.fail(BaseErrorCause.ILLEGAL_PARAMETER.getCode(), error);
	}

	/**
	 * 请求参数校验失败
	 */
	@ExceptionHandler(ValidationException.class)
	public ApiData validExceptionHandler(ValidationException e) {
		return ApiData.fail(BaseErrorCause.ILLEGAL_PARAMETER.getCode(), e.getMessage());
	}

	@ExceptionHandler(MissingRequestHeaderException.class)
	public ApiData missingRequestHeader(MissingRequestHeaderException e) {
		String error = "缺少请求头:" + e.getHeaderName();
		return ApiData.fail(BaseErrorCause.ILLEGAL_PARAMETER.getCode(), error);
	}

	/**
	 * 缺少请求参数
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ApiData validExceptionHandler(HttpMessageNotReadableException e) {
		String error = "缺少请求参数:" + e.getMessage();
		return ApiData.fail(BaseErrorCause.ILLEGAL_PARAMETER.getCode(), error);
	}

	/**
	 * 业务异常
	 */
	@ExceptionHandler({ FrontendBizException.class })
	public ApiData handleMyException(FrontendBizException ex) {
		String error = ex.getMessage();
		return ApiData.fail(ex.getCode(), error);
	}

	/**
	 * 运行时异常
	 */
	@ExceptionHandler({ RuntimeException.class })
	public ApiData handleMyException(RuntimeException ex) {
		final String errorMessage = String.format(BaseErrorCause.SYSTEM_EXCEPTION.getMessagePattern(),
				ex.getClass().getSimpleName());
		final Integer errorCode = BaseErrorCause.SYSTEM_EXCEPTION.getCode();
		StringWriter writer = new StringWriter();
		ex.printStackTrace(new PrintWriter(writer));
		return ApiData.fail(errorCode, errorMessage);
	}

	/**
	 * 未知异常
	 */
	@ExceptionHandler({ Exception.class })
	public ApiData handleMyException(Exception ex) {
		final String errorMessage = String.format(BaseErrorCause.SYSTEM_EXCEPTION.getMessagePattern(),
				ex.getClass().getSimpleName());
		final Integer errorCode = BaseErrorCause.SYSTEM_EXCEPTION.getCode();
		StringWriter writer = new StringWriter();
		ex.printStackTrace(new PrintWriter(writer));
		return ApiData.fail(errorCode, errorMessage);
	}

	@Override
	public boolean supports(MethodParameter returnType, Class converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

		if (body instanceof ApiData) {
			return body;
		}
		return ApiData.success(body);
	}
}
