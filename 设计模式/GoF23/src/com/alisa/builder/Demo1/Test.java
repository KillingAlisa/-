package com.alisa.builder.Demo1;

public class Test {
    public static void main(String[] args) {
        // 指挥
        Director director=new Director();

        // 指挥工人构建:可以实现不同的工人后，指挥不同的工人构造不同产品
        Product product=director.build(new Worker());
        // 不过，一般我们可以通过静态内部类实现零件无序装配构造，这种方式更灵活
    }
}
