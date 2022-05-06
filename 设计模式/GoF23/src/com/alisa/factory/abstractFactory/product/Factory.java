package com.alisa.factory.abstractFactory.product;


// 抽象工厂：抽象的抽象
// 新增产品：直接往接口添加就行，但是非常麻烦
public interface Factory {
    Phone phoneProduct();
    Router routerProduct();
}
