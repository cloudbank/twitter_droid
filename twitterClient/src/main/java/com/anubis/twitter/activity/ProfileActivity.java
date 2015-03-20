package com.anubis.twitter.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.anubis.twitter.R;
import com.anubis.twitter.TwitterClient;
import com.anubis.twitter.model.User;
import com.nostra13.universalimageloader.core.ImageLoader;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ProfileActivity extends FragmentActivity {


    TwitterClient mTwitterClient;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		loadInfo();

	}

	private void loadInfo() {

        mTwitterClient.getTwitterService().getMyInfo(new Callback<User>() {

            @Override
            public void success(User u, Response response) {

                getActionBar().setTitle("@" + u.getScreenName());
                populateProfileHeader(u);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("ERROR", error.toString());
            }

            private void populateProfileHeader(User u) {
                TextView name = (TextView) findViewById(R.id.name);
                TextView tagline = (TextView) findViewById(R.id.screen);
                TextView followers = (TextView) findViewById(R.id.followers);
                TextView following = (TextView) findViewById(R.id.following);
                ImageView image = (ImageView) findViewById(R.id.profImage);
                name.setText(u.getName());
                tagline.setText(u.getTagline());
                followers.setText(u.getFollowers() + " Followers");
                following.setText(u.getFollowing() + " Following");
                ImageLoader.getInstance().displayImage(u.getProfileImageUrl(), image);

            }
        });






	}
}
