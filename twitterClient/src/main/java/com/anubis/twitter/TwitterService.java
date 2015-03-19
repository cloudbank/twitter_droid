package com.anubis.twitter;

import com.anubis.twitter.model.Tweet;
import com.anubis.twitter.model.User;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by sabine on 3/15/15.
 */
public interface TwitterService {


    @GET("/statuses/{timeline}")
    void getTimeline(@Path("timeline") String timeline, @Query("max_id") String maxID, Callback<List<Tweet>> cb);

    @POST("statuses/update.json")
    void sendTweet(@Query("status") String status, Callback<Tweet> cb);

    @GET("account/verify_credentials.json")
    void getMyInfo(Callback<User> cb);


}
