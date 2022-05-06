package com.alisa.factory.method;

import com.alisa.Object.car.Car;

// 工厂方法模式：
// 添加新车型不需要该工厂类
// 可以动态扩展车型：创建对应的工厂
public interface CarFactory {
    Car getCar();
}
