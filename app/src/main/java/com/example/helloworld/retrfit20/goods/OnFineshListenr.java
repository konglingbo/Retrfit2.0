package com.example.helloworld.retrfit20.goods;

import java.util.List;

/**
 * Created by Helloworld on 2017/12/4.
 */

public interface OnFineshListenr {
    void onSuccess(List<Bean> sucess);
    void onErroe(Throwable t);
}
