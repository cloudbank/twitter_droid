package com.anubis.twitter.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableTweet implements Parcelable {


    public static Tweet createTweet(ParcelableTweet pTweet) {return null;}


    public ParcelableTweet(Tweet tweet) {
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}