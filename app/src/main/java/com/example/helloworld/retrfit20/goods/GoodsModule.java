package com.example.helloworld.retrfit20.goods;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Helloworld on 2017/12/4.
 */

@Module
public class GoodsModule {

    private GoodsView view;


    public GoodsModule(GoodsView view) {
        this.view = view;
    }

    @Provides
    GoodsView getgoodsview(){
        return view;
    }
}
