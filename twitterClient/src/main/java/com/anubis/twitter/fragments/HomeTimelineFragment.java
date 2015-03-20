package com.anubis.twitter.fragments;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.anubis.twitter.activity.TimelineActivity;
import com.anubis.twitter.model.Tweet;

import java.util.ArrayList;

public class HomeTimelineFragment extends TweetsListFragment {

	
	@Override
	//@todo callbacks
	public void onResume() {
		super.onResume();
		FragmentActivity tla = this.getActivity();
		ArrayList<Tweet> fragTweets = (ArrayList<Tweet>) ((TimelineActivity) tla)
				.getFragmentTweets();
		if (fragTweets.size() > 0) {
			for (Tweet t : fragTweets) {
				mTweetsList.add(0, t);
			}
		}
		mAdapter.notifyDataSetChanged();
		((TimelineActivity) getActivity()).clearFragmentTweets();

		Log.d("DEBUG", "resuming the frag" + mTweetsList);
	}

	

	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (resultCode == getActivity().RESULT_OK
				&& requestCode == REQUEST_CODE) {
			Tweet tweet = (Tweet) data.getSerializableExtra("tweet");
			Log.d("DEBUG", "onActivityResult" + getClass()
					+ mTweetsList.get(0).toString());
			mTweetsList.add(0, tweet);
			mAdapter.notifyDataSetChanged();
		}

	}


    @Override
    String getTimeline() {
        return "home_timeline.json";
    }
}
