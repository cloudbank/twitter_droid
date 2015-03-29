package com.anubis.twitter.fragments;

public class MentionsTimelineFragment extends BaseTimelineFragment {





    @Override
    String getTimeline() {
        return "mentions_timeline.json";
    }
}
