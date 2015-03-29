package com.anubis.twitter;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterSession;


public class TwitterClient extends TwitterApiClient {
    public static TwitterClient mInstance;
    static TwitterSession mSession;

    private TwitterClient(TwitterSession session) {
        super(session);
        mSession = session;
    }

    public static TwitterSession getSession() {
        if (mSession == null) {
            mSession =
                    Twitter.getSessionManager().getActiveSession();
        }
        return mSession;
    }

    public static void setSession(TwitterSession session) {
        mSession = session;
    }

    public static TwitterClient getInstance() {
        if (mInstance == null) {
            mInstance = new TwitterClient(getSession());
        }
        return mInstance;
    }

    /**
     * Provide CustomService with defined endpoints
     */
    public TwitterService getTwitterService() {
        return getService(TwitterService.class);
    }
}



