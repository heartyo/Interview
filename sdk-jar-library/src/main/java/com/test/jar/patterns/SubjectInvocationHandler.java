package com.test.jar.patterns;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class SubjectInvocationHandler implements java.lang.reflect.InvocationHandler {

    private Object object;

    public SubjectInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
//        System.out.println("o = " + o + ", method = " + method + ", objects = " + Arrays.deepToString(objects));
        System.out.println( ", method = " + method );//method = public abstract void com.test.jar.patterns.Subject2.buy()
        System.out.println( ", objects = " + objects[0] );//objects = 真实对象的参数
        Object result = method.invoke(object, objects);//执行方法
        return result;
    }
}
