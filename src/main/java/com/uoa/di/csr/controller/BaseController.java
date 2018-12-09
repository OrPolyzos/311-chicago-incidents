package com.uoa.di.csr.controller;

public class BaseController {

    protected static String redirectToUri(String uri) {
        return "redirectToUri:" + uri;
    }
}
