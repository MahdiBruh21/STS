	package com.example.demo.bean;

import org.springframework.stereotype.Component;

@Component("eng")
public class HelloBean implements
IHello {
public String getMessage(String msg)
{
return "Hello Spring"+msg;
}
}