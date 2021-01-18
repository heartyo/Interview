package com.test.jar.patterns;

import java.lang.reflect.Proxy;

class Client {

    public static void main(String[] args) {

        RealSubject realSubject = new RealSubject();
        ProxySubject proxySubject = new ProxySubject(realSubject);
        proxySubject.sale();

        SubjectInvocationHandler dynamicProxy = new SubjectInvocationHandler(realSubject);

        Subject2 subject2 = (Subject2) Proxy.newProxyInstance(dynamicProxy.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), dynamicProxy);
        subject2.buy(10000);
    }
}
