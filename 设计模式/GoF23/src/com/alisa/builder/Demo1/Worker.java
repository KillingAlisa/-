package com.alisa.builder.Demo1;

// 工人，负责构造
public class Worker extends Builder{
    private Product product;

    public Worker(){
        product=new Product();
    }
    @Override
    void buildA() {
        product.setA("A");
    }

    @Override
    void buildB() {
        product.setB("B");
    }

    @Override
    void buildC() {
        product.setC("C");
    }

    @Override
    Product getProduct() {
        return product;
    }
}
