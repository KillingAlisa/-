package com.alisa.builder.Demo1;

// 指挥：核心。负责指挥构建一个产品。
public class Director {
    // 指挥Worker。按照顺序构建
    public Product build(Builder builder){
        builder.buildA();
        builder.buildB();
        builder.buildC();

        return builder.getProduct();
    }
}
