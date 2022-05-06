package com.alisa.builder.Demo2;

// 抽象的建造者：方法
public abstract class Builder {
    // 构造产品
    abstract Builder buildA(String a);
    abstract Builder buildB(String b);
    abstract Builder buildC(String c);

    // 得到产品
    abstract Product getProduct();
}
