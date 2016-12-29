package com.tzs.eyepetizer.apiservice;

import com.tzs.eyepetizer.entity.Follow;
import com.tzs.eyepetizer.util.PathUtil;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Administrator on 2016/12/29.
 */
public interface HttpApiService {

    @GET("http://baobab.kaiyanapp.com/api/v4/tabs/follow/")
    Observable<Follow> getFollowList();
}
