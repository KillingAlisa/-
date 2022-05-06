package com.alisa.factory.abstractFactory.Impl.Xiaomi;

import com.alisa.factory.abstractFactory.product.Phone;

public class MiPhone implements Phone {

    @Override
    public void start() {
        System.out.println("Hello,XiaoMi");
    }

    @Override
    public void shutdown() {
        System.out.println("Bye,XiaoMi");
    }

    @Override
    public void call() {
        System.out.println("Call XiaoMi");
    }

    @Override
    public void sendSMS() {
        System.out.println("Send XiaoMi");
    }
}
