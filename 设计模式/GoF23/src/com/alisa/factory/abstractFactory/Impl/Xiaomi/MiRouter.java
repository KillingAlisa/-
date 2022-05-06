package com.alisa.factory.abstractFactory.Impl.Xiaomi;

import com.alisa.factory.abstractFactory.product.Router;

public class MiRouter implements Router {

    @Override
    public void start() {
        System.out.println("Xiaomi");
    }

    @Override
    public void shutdown() {
        System.out.println("Xiaomi");
    }

    @Override
    public void setting() {
        System.out.println("Xiaomi");
    }
}
