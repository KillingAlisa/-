package com.alisa.factory.abstractFactory.Impl.HuaWei;

import com.alisa.factory.abstractFactory.product.Phone;

public class HuaWeiPhone implements Phone {
    @Override
    public void start() {
        System.out.println("Hello,HuaWei");
    }

    @Override
    public void shutdown() {
        System.out.println("Bye,HuaWei");
    }

    @Override
    public void call() {
        System.out.println("Call,HuaWei");
    }

    @Override
    public void sendSMS() {
        System.out.println("Send,HuaWei");
    }
}
