package com.example.helloworld.retrfit20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.helloworld.retrfit20.goods.Bean;
import com.example.helloworld.retrfit20.goods.DaggerGoodsComponent;
import com.example.helloworld.retrfit20.goods.GoodsModule;
import com.example.helloworld.retrfit20.goods.GoodsPresenter;
import com.example.helloworld.retrfit20.goods.GoodsView;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements GoodsView{

    @Inject
    GoodsPresenter goodsPre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerGoodsComponent.builder().goodsModule(new GoodsModule(this)).build().inject(this);


        goodsPre.guanLian();


    }

    @Override
    public void showGoods(List<Bean> sView) {
        String name = sView.get(0).getName();
       // Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
        Log.e("hahahahaha", name );
    }
}
