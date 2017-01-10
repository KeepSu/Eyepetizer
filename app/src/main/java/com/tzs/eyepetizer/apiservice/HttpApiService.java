package com.tzs.eyepetizer.apiservice;

import com.tzs.eyepetizer.entity.AuthorDetail;
import com.tzs.eyepetizer.entity.Follow;
import com.tzs.eyepetizer.entity.Search;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * HttpApiService
 */
public interface HttpApiService {
    //关注页面首页
    @GET("api/v4/tabs/follow/")
    Observable<Follow> getFollowList();

    //"http://baobab.kaiyanapp.com/
    // api/v4/tabs/follow?
    // start=2&
    // num=2&
    // follow=false&
    // startId=0"
    //关注页面加载更多
    @GET("api/v4/tabs/follow?")
    Observable<Follow> getFollowNextList(@Query("start") String start,
                                         @Query("num") String num,
                                         @Query("follow") String follow,
                                         @Query("startId") String startId);

    //作者详情页面
    @GET("api/v3/pgc/videos?")
    Observable<AuthorDetail> getAuthorDetailVideoList(@Query("start") String start,
                                                      @Query("num") String num,
                                                      @Query("pgcId") String pgcId,
                                                      @Query("strategy") String strategy);

    //http://baobab.kaiyanapp.com/api/v1/search?/query="城会玩"
    @GET("api/v1/search?")
    Observable<Search> getSearchList(@Query("start") String start,
                                     @Query("num") String num,
                                     @Query("query") String query);
}
