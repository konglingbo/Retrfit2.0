package com.example.helloworld.retrfit20;

/**
 * Created by Helloworld on 2017/12/4.
 */

public class Api {

    private static boolean isDebug = true;

    public static final String onTestUrl = "http://baobab.kaiyanapp.com/";
    public static final String onLineUrl = "http://baobab.kaiyanapp.com/";
    //http://baobab.kaiyanapp.com/api/v2/categories?udid=26868b32e808498db32fd51fb422d00175e179df&vc=83

    public static final String url = baseUrl()+"api/v2/";

    private static String baseUrl(){
        return isDebug ? onTestUrl : onLineUrl;
    }
}
