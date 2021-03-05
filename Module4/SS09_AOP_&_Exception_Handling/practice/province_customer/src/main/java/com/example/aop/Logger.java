package com.example.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class Logger {
    public void error() {
        System.out.println( "[CMS] ERROR!" );
    }

    @After("execution(public * com.example.service.CustomerService.remove(..))")
    public void log() {
        System.out.println( "Delete" );
    }

    @After("execution(public * com.example.service.CustomerService.findAll(..))")
    public void log1() {
        System.out.println( "Show" );
    }

    @After("execution(public * com.example.service.CustomerService.save(..))")
    public void log2() {
        System.out.println( "Save" );
    }



}
