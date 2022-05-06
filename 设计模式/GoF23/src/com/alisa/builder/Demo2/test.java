package com.alisa.builder.Demo2;

public class test {
    public static void main(String[] args) {
        // 工人负责创建
        Worker worker=new Worker();
        // 链式编程
        Product product=worker.buildA("a").buildB("b").buildC("c").getProduct();

        System.out.println(product);

    }
}
