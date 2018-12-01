package com.uoa.di.csr.controller;

public class BaseController {

    protected static String redirect(String uri) {
        return "redirect:" + uri;
    }
}
