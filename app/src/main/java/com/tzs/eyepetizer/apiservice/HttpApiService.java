package com.tzs.eyepetizer.apiservice;

import com.tzs.eyepetizer.entity.Follow;
import com.tzs.eyepetizer.util.PathUtil;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/12/29.
 */
public interface HttpApiService {

    @GET("http://baobab.kaiyanapp.com/api/v4/tabs/follow/")
    Observable<Follow> getFollowList();

    //"http://baobab.kaiyanapp.com/
    // api/v4/tabs/follow?
    // start=2&
    // num=2&
    // follow=false&
    // startId=0"
    @GET("api/v4/tabs/follow?")
    Observable<Follow> getFollowNextList(@Query("start") String start,
                                         @Query("num") String num,
                                         @Query("follow") String follow,
                                         @Query("startId") String startId);
}
