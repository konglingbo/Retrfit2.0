package com.example.helloworld.retrfit20.goods;

import android.util.Log;

import com.example.helloworld.retrfit20.Api;
import com.example.helloworld.retrfit20.ApiService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Helloworld on 2017/12/4.
 */

public class GoodsModel {

    @Inject
    public GoodsModel(){

    }

    public void getDate(final OnFineshListenr listenr){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("xxx", message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
                .build();
        Retrofit build = new Retrofit.Builder().baseUrl(Api.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        ApiService apiService = build.create(ApiService.class);

        Flowable<List<Bean>> flowable = apiService.getDateNet("26868b32e808498db32fd51fb422d00175e179df", 83);

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<List<Bean>>() {
                    @Override
                    public void onNext(List<Bean> been) {
                        if (listenr!=null){
                            listenr.onSuccess(been);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        if (listenr!=null){
                            listenr.onErroe(t);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}
