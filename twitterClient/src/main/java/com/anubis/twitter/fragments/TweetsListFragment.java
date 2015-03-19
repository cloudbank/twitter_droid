package com.anubis.twitter.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.anubis.twitter.activity.ComposeActivity;
import com.anubis.twitter.R;
import com.anubis.twitter.TweetArrayAdapter;
import com.anubis.twitter.TwitterApp;
import com.anubis.twitter.TwitterClient;
import com.anubis.twitter.TwitterService;
import com.anubis.twitter.activity.ProfileActivity;
import com.anubis.twitter.listeners.EndlessScrollListener;
import com.anubis.twitter.model.Tweet;

import java.util.ArrayList;
import java.util.List;

import eu.erikw.PullToRefreshListView;
import eu.erikw.PullToRefreshListView.OnRefreshListener;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public abstract class TweetsListFragment extends Fragment implements ScrollingTimeline {
    final int REQUEST_CODE = 20;
    ArrayAdapter<Tweet> mAdapter;
    PullToRefreshListView mListView;
    TwitterClient mTwitterClient;
    ArrayList<Tweet> mTweetsList;
    TwitterService mTwitterService;


    abstract String getTimeline();

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_menu_timeline, menu);
    }

    private void openCompose() {
        Intent i = new Intent(getActivity(), ComposeActivity.class);
        startActivityForResult(i, REQUEST_CODE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mi_compose:
                openCompose();
                break;
            case R.id.mi_profile:
                openProfile();
                break;
            default:
                break;
        }
        return true;
    }

    private void openProfile() {
        Intent i = new Intent(getActivity(), ProfileActivity.class);
        startActivity(i);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTwitterClient = TwitterApp.getRestClient();
        mTwitterService = TwitterApp.getRestService();
        mTweetsList = new ArrayList<Tweet>();
        mAdapter = new TweetArrayAdapter(getActivity(), mTweetsList);
        setHasOptionsMenu(true);
        populateTimeline( true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tweets_list, container,
                false);

        mListView = (PullToRefreshListView) v.findViewById(R.id.lvTweets);
        mListView.setAdapter(mAdapter);
        mListView.setOnScrollListener(new EndlessScrollListener() {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to your
                // AdapterView
                Log.d("DEBUG", "detected scroll" + page);
                // there is some bug in scroll after I added the pull down
                // refresh library
                if (totalItemsCount > 1) {
                    customLoadMoreDataFromApi(page);
                }
            }
        });
        mListView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call listView.onRefreshComplete() when
                // once the network request has completed successfully.
                populateTimeline(true);
            }
        });
        return v;

    }

    public void populateTimeline( boolean clear) {
        long lowId = 0;
        if (clear) {
            mTweetsList.clear();
            mAdapter.clear();
            mAdapter.notifyDataSetChanged();
        } else {
            lowId = mTweetsList.get(mTweetsList.size() - 1).getId();
            lowId--;
        }

        mTwitterService.getTimeline(getTimeline(), String.valueOf(lowId), new Callback<List<Tweet>>() {
            @Override
            public void success(List<Tweet> tasks, Response response) {
                mAdapter.addAll(tasks);
                mListView.onRefreshComplete();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("ERROR", error.toString());
            }
        });


    }


    public void customLoadMoreDataFromApi(int offset) {
        // This method probably sends out a network request and appends new data
        // items to your adapter.
        // Use the offset value and add it as a parameter to your API request to
        // retrieve paginated data.
        // Deserialize API response and then construct new objects to append to
        // the adapter

        populateTimeline(false);

    }

}
