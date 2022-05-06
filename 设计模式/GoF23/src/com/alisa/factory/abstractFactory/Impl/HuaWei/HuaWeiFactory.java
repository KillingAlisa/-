package com.alisa.factory.abstractFactory.Impl.HuaWei;

import com.alisa.factory.abstractFactory.product.Factory;
import com.alisa.factory.abstractFactory.product.Phone;
import com.alisa.factory.abstractFactory.product.Router;

public class HuaWeiFactory implements Factory {
    @Override
    public Phone phoneProduct() {
        return new HuaWeiPhone();
    }

    @Override
    public Router routerProduct() {
        return new HuaWeiRouter();
    }
}
