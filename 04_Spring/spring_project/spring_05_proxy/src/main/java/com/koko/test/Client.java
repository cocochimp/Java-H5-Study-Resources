package com.koko.test;

import com.koko.service.UserService;
import com.koko.service.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService = new UserServiceImpl();

        //代理角色，不存在
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();

        //设置要代理的对象
        proxyInvocationHandler.setTarget(userService);

        //注意要用接口强转，否则会报异常
        UserService proxy = (UserService)proxyInvocationHandler.getProxy();
        proxy.add();
        proxy.delete();
    }
}
