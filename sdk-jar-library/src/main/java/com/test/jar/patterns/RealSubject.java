package com.test.jar.patterns;

import com.test.jar.PrintUtil;

public class RealSubject implements Subject ,Subject2 {
    @Override
    public void sale() {
        System.out.println(PrintUtil.encode("客户需要卖房"));

    }

    @Override
    public void buy(int money) {
        System.out.println("客户需要买房最低价格：" + money);

    }
}
