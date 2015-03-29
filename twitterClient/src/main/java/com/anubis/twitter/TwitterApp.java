package com.anubis.twitter;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import com.activeandroid.ActiveAndroid;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
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
    //@todo buildconfig
    private static final String TWITTER_KEY = "hUULy3KuPrFmI7evGMRCFGsmg";
    private static final String TWITTER_SECRET = "eqPQnY8shJEF6PW9jVZ7sAnb6vmrbP84cwAqkIyas1KOPZZQTo";
	private static Context context;


    private static TwitterApp singleton;
    private Typeface avenirFont;

    public static TwitterApp getInstance() {
        return singleton;
    }
    public Typeface getTypeface() {
        if (avenirFont == null) {
            extractAvenir();
        }
        return avenirFont;
    }
    private void extractAvenir() {
        avenirFont = Typeface.createFromAsset(getAssets(), "fonts/Avenir.ttc");
    }





    @Override
	public void onCreate() {
		super.onCreate();
        singleton = this;
        extractAvenir();
        TwitterAuthConfig authConfig =
                new TwitterAuthConfig(TWITTER_KEY,TWITTER_SECRET);
		Fabric.with(this, new Twitter(authConfig));
		TwitterApp.context = this;
        ActiveAndroid.initialize(this);
		// Create global configuration and initialize ImageLoader with this configuration
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .displayer(new RoundedBitmapDisplayer(5)) //rounded corner bitmap
                .cacheInMemory()
                .imageScaleType(ImageScaleType.EXACTLY)
                .cacheOnDisc()
                .showStubImage(android.R.drawable.btn_star)
                .resetViewBeforeLoading()
                .build();

		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
		.defaultDisplayImageOptions(options)
		.build();
		ImageLoader.getInstance().init(config);
	}


    public static TwitterClient getTwitterClient() {
        return (TwitterClient) TwitterClient.getInstance();
    }



}