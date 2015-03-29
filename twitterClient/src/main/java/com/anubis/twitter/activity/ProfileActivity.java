package com.anubis.twitter.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.anubis.twitter.R;
import com.anubis.twitter.TwitterApp;
import com.anubis.twitter.TwitterClient;
import com.nostra13.universalimageloader.core.ImageLoader;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ProfileActivity extends FragmentActivity {


    TwitterClient mTwitterClient;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mTwitterClient = TwitterApp.getTwitterClient();
		setContentView(R.layout.activity_profile);
		loadInfo();

	}

	private void loadInfo() {
        mTwitterClient.getTwitterService().getMyInfo(new Callback< com.twitter.sdk.android.core.models.User>() {

            @Override
            public void success( com.twitter.sdk.android.core.models.User u, Response response) {

                getActionBar().setTitle("@" + u.screenName);
                populateProfileHeader(u);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("ERROR", error.toString());
            }

            private void populateProfileHeader(com.twitter.sdk.android.core.models.User u) {
                TextView name = (TextView) findViewById(R.id.name);
                TextView tagline = (TextView) findViewById(R.id.screen);
                TextView followers = (TextView) findViewById(R.id.followers);
                TextView following = (TextView) findViewById(R.id.following);
                ImageView image = (ImageView) findViewById(R.id.profImage);
                name.setText(u.name);
               // tagline.setText(u.tagLine);
                followers.setText(u.followersCount + " Followers");
                following.setText(u.friendsCount  +" Following");
                ImageLoader.getInstance().displayImage(u.profileImageUrl, image);

            }
        });






	}
}
