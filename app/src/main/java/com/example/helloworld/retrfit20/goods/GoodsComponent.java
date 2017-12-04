package com.example.helloworld.retrfit20.goods;

import com.example.helloworld.retrfit20.MainActivity;

import dagger.Component;

/**
 * Created by Helloworld on 2017/12/4.
 */

@Component(modules = GoodsModule.class)
public interface GoodsComponent {
    void inject(MainActivity mainActivity);
}
