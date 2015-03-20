package com.anubis.twitter.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.anubis.twitter.R;
import com.anubis.twitter.TwitterApp;
import com.anubis.twitter.TwitterClient;
import com.anubis.twitter.model.Tweet;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ComposeActivity extends Activity {

	EditText etCompose;
	//TwitterClient client;
    TwitterClient mTwitterClient;
	ArrayAdapter<Tweet> aTweets;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compose);
		//client = TwitterApp.getRestClient();
        mTwitterClient = TwitterApp.getTwitterClient();
		etCompose = (EditText) findViewById(R.id.etCompose);
		etCompose.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				TextView tv = (TextView) findViewById(R.id.tvCount);
				tv.setText(String.valueOf(s.length()));

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

	}

	private boolean checkTweet(CharSequence s) {
		boolean val;
		if (val = (s.toString().length() > 140)) {
			Toast.makeText(this, "140 chars or less", Toast.LENGTH_SHORT)
					.show();
		}
		return !val;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.compose, menu);
		return true;
	}

	public void composeTweet(View v) {
		String text = etCompose.getText().toString();
		if (!checkTweet(text)) {
			return;
		}
		// post the tweet to twitter and open timeline
		postTweet(text);

	}

	// texthandler for 140 chars
	//
	private void postTweet(String status) {


        mTwitterClient.getTwitterService().sendTweet(status, new Callback<Tweet>() {

            @Override
            public void success(Tweet tweet, Response response) {
                Intent data = new Intent();
                data.putExtra("tweet", tweet);
                setResult(RESULT_OK, data);
                finish();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("ERROR", error.toString());
            }
        });


	}

}
