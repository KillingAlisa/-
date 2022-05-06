package com.alisa.builder.Demo1;

// 抽象的建造者：方法
public abstract class Builder {
    // 构造产品
    abstract void buildA();
    abstract void buildB();
    abstract void buildC();

    // 得到产品
    abstract Product getProduct();
}
