package com.ram.springboot.dao;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String msg){
        super(msg);
    }

    public EmployeeNotFoundException(String msg,Throwable e){
        super(msg,e);
    }
}
