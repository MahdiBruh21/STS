package com.example.demo.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("fr")
@Primary
public class BonjourBean implements IHello {
public String getMessage(String msg)
{
return "Bonjour"+msg;
}
}