package com.example.helloworld.retrfit20;

import com.example.helloworld.retrfit20.goods.Bean;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Helloworld on 2017/12/4.
 */

public interface ApiService {

    //http://baobab.kaiyanapp.com/api/v2/categories?udid=26868b32e808498db32fd51fb422d00175e179df&vc=83

    @GET("categories")
    Flowable<List<Bean>> getDateNet(@Query("udid") String udid, @Query("vc") int vc);

}
