package com.anubis.twitter.fragments;

import android.content.Intent;

import com.anubis.twitter.activity.TimelineActivity;
import com.anubis.twitter.model.Tweet;
public class MentionsTimelineFragment extends TweetsListFragment {


	public void onActivityResult(int requestCode, int resultCode, Intent data) {

		// REQUEST_CODE is defined above
		if (resultCode == getActivity().RESULT_OK
				&& requestCode == REQUEST_CODE) {
			Tweet tweet = (Tweet) data.getSerializableExtra("tweet");
			((TimelineActivity) getActivity()).setFragmentTweets(tweet);
		}

	}


    @Override
    String getTimeline() {
        return "mentions_timeline.json";
    }
}
