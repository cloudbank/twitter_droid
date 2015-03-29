package com.anubis.twitter.fragments;

public class HomeTimelineFragment extends BaseTimelineFragment {

	
	@Override
	//@todo callbacks
	public void onResume() {
		super.onResume();
		/* FragmentActivity tla = this.getActivity();
		ArrayList<Tweet> fragTweets = (ArrayList< Tweet>) ((TimelineActivity) tla)
				.getFragmentTweets();
		if (fragTweets.size() > 0) {
			for ( Tweet t : fragTweets) {
				mTweetsList.add(0, t);
			}
		}
		mAdapter.notifyDataSetChanged();
		((TimelineActivity) getActivity()).clearFragmentTweets();

		Log.d("DEBUG", "resuming the frag" + mTweetsList); */
	}

	

	



    @Override
    String getTimeline() {
        return "home_timeline.json";
    }
}
