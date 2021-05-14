package com.zw.cn.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.zw.cn.base.BaseResult;
import com.zw.cn.base.ResultEnum;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

/**
 * 封装统一的异常处理
 *
 * @author ZhaoWei
 * @date 2020/5/15 9:39 上午
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    BaseResult handleServiceException(HttpServletRequest request, Throwable ex) {
        ServiceException bex = (ServiceException)ex;
        LOGGER.warn("{} request error , code: {}, message: {}", request.getRequestURI(), bex.getCode(),
            bex.getMessage());
        return BaseResult.createFailResult(bex.getMessage(), bex.getCode());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    BaseResult handleException(HttpServletRequest request, Throwable ex) {
        LOGGER.error("{} request error :", request.getRequestURI(), ex);
        return BaseResult.createFailResult(ResultEnum.SYS_ERROR.getMsg(), ResultEnum.SYS_ERROR.getCode());
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    BaseResult handleBindException(HttpServletRequest request, Throwable cex) {
        BindingResult result = ((BindException)cex).getBindingResult();
        return BaseResult.createFailResult(paramResult(request, result), ResultEnum.PARAM_ERROR.getCode());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    BaseResult handleHttpMessageNotReadableException(HttpServletRequest request, Throwable ex) {
        String message;
        String errorCode;
        if (ex.getCause() instanceof InvalidFormatException) {
            InvalidFormatException hex = (InvalidFormatException)(ex.getCause());
            errorCode = ResultEnum.PARAM_TYPE_ERROR.getCode();
            List<JsonMappingException.Reference> path = new ArrayList<>();
            if (hex != null) {
                path = hex.getPath();
            }
            if (CollectionUtils.isNotEmpty(path)) {
                String fieldName = path.get(0).getFieldName();
                message = fieldName + ResultEnum.PARAM_ERROR.getMsg();
            } else {
                message = ResultEnum.PARAM_TYPE_ERROR.getMsg();
            }
        } else {
            message = ResultEnum.PARSE_ERROR.getMsg();
            errorCode = ResultEnum.PARSE_ERROR.getCode();
        }
        LOGGER.error("{} request error , {}", request.getRequestURI(), ex);
        return BaseResult.createFailResult(message, errorCode);
    }

    @ExceptionHandler(JsonProcessingException.class)
    @ResponseBody
    BaseResult handleJsonProcessingException(HttpServletRequest request, Throwable ex) {
        String errorCode = ResultEnum.JSON_PARSER_ERROR.getCode();
        JsonProcessingException cex = (JsonProcessingException)ex.getCause();
        String message = "Json格式错误";
        cex.printStackTrace();
        LOGGER.error("{} request error , {}", request.getRequestURI(), cex.getMessage());
        return BaseResult.createFailResult(message, errorCode);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    BaseResult handleConstraintViolationException(HttpServletRequest request, Throwable ex) {
        String errorCode = ResultEnum.PARAM_ERROR.getCode();
        ConstraintViolationException cex = (ConstraintViolationException)ex;
        StringBuilder stringBuilder = new StringBuilder();
        Optional.ofNullable(cex.getConstraintViolations()).orElse(new HashSet<>()).forEach(v -> {
            String invalid = v.getInvalidValue() != null ? v.getInvalidValue().toString() : "null";
            stringBuilder.append(v.getPropertyPath()).append(" ").append(v.getMessage()).append(", 当前值: '")
                .append(invalid.length() < 50 ? invalid : invalid.substring(0, 47) + "...").append("'; ");
        });
        String message = stringBuilder.toString();

        LOGGER.error("{} request error , {}", request.getRequestURI(), message);
        return BaseResult.createFailResult(message, errorCode);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    BaseResult handleMethodArgumentNotValidException(HttpServletRequest request, Throwable ex) {
        String errorCode = ResultEnum.PARAM_ERROR.getCode();
        BindingResult result = ((MethodArgumentNotValidException)ex).getBindingResult();
        String message = paramResult(request, result);
        return BaseResult.createFailResult(message, errorCode);
    }

    private String paramResult(HttpServletRequest request, BindingResult result) {
        StringBuilder stringBuilder = new StringBuilder();
        Optional.of(result.getFieldErrors()).orElse(new ArrayList<>()).forEach(f -> {
            stringBuilder.append(f.getField()).append(" ").append(f.getDefaultMessage()).append(", 当前值: '")
                .append(f.getRejectedValue()).append("'; ");
        });
        String message = stringBuilder.toString();
        LOGGER.error("{} request error , {}", request.getRequestURI(), message);
        return message;
    }
}
