package com.anubis.twitter;

import com.anubis.twitter.model.Tweet;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

public interface TwitterService {



    public static final String REST_URL = "https://api.twitter.com/1.1";
    public static final String REST_CALLBACK_URL = "oauth://cpbasictweets";

    @GET("/1.1/statuses/{timeline}")
    void getTimeline(@Path("timeline") String timeline, @Query("max_id") String maxID, Callback<List<Tweet>> cb);

    @POST("/1.1/statuses/update.json")
    void sendTweet(@Query("status") String status, Callback<Tweet> cb);

    @GET("/1.1/account/verify_credentials.json")
    void getMyInfo(Callback<com.twitter.sdk.android.core.models.User> cb);


}
