package com.alisa.builder.Demo2;



public class Worker extends Builder{
    private Product product;

    @Override
    Builder buildA(String a) {
        product.setA(a);
        return this;
    }

    @Override
    Builder buildB(String b) {
        product.setB(b);
        return this;
    }

    @Override
    Builder buildC(String c) {
        product.setC(c);
        return this;
    }

    @Override
    Product getProduct() {
        return product;
    }
}
