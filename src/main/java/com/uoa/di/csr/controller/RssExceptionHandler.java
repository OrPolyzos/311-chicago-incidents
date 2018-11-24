package com.uoa.di.csr.controller;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RssExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String EXCEPTION_MESSAGE_TEMPLATE = "URI: %s | Exception Message: %s";
    private static final String RSS_INTERNAL_ERROR_PAGE = "error/500";
    private static final String RSS_NOT_FOUND_ERROR_PAGE = "error/404";
//
//    private final EventLogger eventLogger;
//
//    @Autowired
//    public RssExceptionHandler(EventLogger eventLogger) {
//        this.eventLogger = eventLogger;
//    }
//
//    @ExceptionHandler(value = {RssException.class})
//    protected ModelAndView hangleGeneralConflicts(Exception ex, WebRequest request) {
//        String uri = ((ServletWebRequest) request).getRequest().getRequestURI();
//        eventLogger.error(String.format(EXCEPTION_MESSAGE_TEMPLATE, uri, ex.getMessage()));
//        ex.printStackTrace();
//        ModelAndView modelAndView = new ModelAndView(RSS_INTERNAL_ERROR_PAGE);
//        modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
//        return modelAndView;
//    }
//
//    @ExceptionHandler(value = {RssNotFoundException.class})
//    protected ModelAndView handleNotFoundConflicts(RssNotFoundException ex, WebRequest request) {
//        String uri = ((ServletWebRequest) request).getRequest().getRequestURI();
//        eventLogger.error(String.format(EXCEPTION_MESSAGE_TEMPLATE, uri, ex.getMessage()));
//        ModelAndView modelAndView = new ModelAndView(RSS_NOT_FOUND_ERROR_PAGE);
//        modelAndView.setStatus(HttpStatus.NOT_FOUND);
//        return modelAndView;
//    }
}
