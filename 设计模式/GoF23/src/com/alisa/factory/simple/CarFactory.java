package com.alisa.factory.simple;

import com.alisa.Object.car.Car;
import com.alisa.Object.car.Porsche;
import com.alisa.Object.car.Tesla;

public class CarFactory {
    // 静态（简单）工厂模式，增加车型要修改代码，不符合开闭原则。
    public static Car getCar(String car){
        if(car.equals("Tesla")){
            return new Tesla();
        }else if(car.equals("Porsche")){
            return new Porsche();
        }else{
            return null;
        }
    }
}
