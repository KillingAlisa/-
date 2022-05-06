package com.alisa.factory.abstractFactory.Impl.HuaWei;

import com.alisa.factory.abstractFactory.product.Router;

public class HuaWeiRouter implements Router {

    @Override
    public void start() {
        System.out.println("HuaWei");
    }

    @Override
    public void shutdown() {
        System.out.println("HuaWei");
    }

    @Override
    public void setting() {
        System.out.println("HuaWei");
    }
}
