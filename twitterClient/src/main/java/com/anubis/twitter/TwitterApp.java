package com.anubis.twitter;

import android.app.Application;
import android.content.Context;

import com.activeandroid.ActiveAndroid;
import com.anubis.twitter.service.ServiceGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

/*
 * This is the Android application itself and is used to configure various settings
 * including the image cache in memory and on disk. This also adds a singleton
 * for accessing the relevant rest client.
 * 
 *     RestClient client = RestClientApp.getRestClient();
 *     // use client to send requests to API
 *     
 */
public class TwitterApp extends Application {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "hUULy3KuPrFmI7evGMRCFGsmg";
    private static final String TWITTER_SECRET = "eqPQnY8shJEF6PW9jVZ7sAnb6vmrbP84cwAqkIyas1KOPZZQTo";
	private static Context context;
    public static final String REST_URL = "https://api.twitter.com/1.1";


    @Override
	public void onCreate() {
		super.onCreate();
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
		Fabric.with(this, new Twitter(authConfig));
		TwitterApp.context = this;
        ActiveAndroid.initialize(this);
		// Create global configuration and initialize ImageLoader with this configuration
		DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().
				cacheInMemory().cacheOnDisc().build();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
		.defaultDisplayImageOptions(defaultOptions)
		.build();
		ImageLoader.getInstance().init(config);
        //Fabric.with(this, new Twitter(authConfig));
	}

	public static TwitterClient getRestClient() {
		return (TwitterClient) TwitterClient.getInstance(TwitterClient.class, TwitterApp.context);
	}
    public static TwitterService getRestService() {
        return (TwitterService) ServiceGenerator.createService(TwitterService.class,REST_URL );
    }
}