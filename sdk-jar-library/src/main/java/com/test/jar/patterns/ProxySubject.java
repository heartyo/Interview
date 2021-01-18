package com.test.jar.patterns;

import com.test.jar.PrintUtil;

class ProxySubject implements Subject {

    Subject iHourse;

    public ProxySubject(Subject iHourse) {
        this.iHourse = iHourse;
    }

    @Override
    public void sale() {
        iHourse.sale();
        System.out.println(PrintUtil.encode("帮客户卖房"));

    }
}
