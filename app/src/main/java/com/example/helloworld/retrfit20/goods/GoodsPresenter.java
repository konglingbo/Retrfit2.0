package com.example.helloworld.retrfit20.goods;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Helloworld on 2017/12/4.
 */

public class GoodsPresenter implements OnFineshListenr{

    @Inject
    GoodsModel goodsModel;
    private GoodsView goodsView;

    @Inject
    public GoodsPresenter(GoodsView goodsView){
        this.goodsView = goodsView;
    }


    public void guanLian(){
        goodsModel.getDate(this);
    }

    @Override
    public void onSuccess(List<Bean> sucess) {
        goodsView.showGoods(sucess);
    }

    @Override
    public void onErroe(Throwable t) {

    }
}
