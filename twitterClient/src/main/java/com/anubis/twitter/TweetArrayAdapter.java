package com.anubis.twitter;

import android.content.Context;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.anubis.twitter.model.Tweet;
import com.google.gson.internal.LinkedTreeMap;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TweetArrayAdapter extends ArrayAdapter<Tweet> {
    Context context;

    public TweetArrayAdapter(Context context, List<Tweet> tweets) {
        super(context, 0, tweets);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tweet t = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;
        RelativeLayout layout;
        if (convertView == null) {

            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tweet_item,
                    parent, false);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.ivProfileImage);
            viewHolder.screen = (TextView) convertView.findViewById(R.id.tvScreenName);
            viewHolder.user = (TextView) convertView.findViewById(R.id.tvUserName);
            viewHolder.timestamp = (TextView) convertView.findViewById(R.id.tvTimeStamp);
            viewHolder.body = (TextView) convertView.findViewById(R.id.tvBody);
            viewHolder.embeddedImage = (ImageView) convertView.findViewById(R.id.embeddedImage);


           /* layout = (RelativeLayout) convertView.findViewById(R.id.relLayoutTweetItem);
            viewHolder.ctv = new TweetView(context, t,
                    R.style.tw__TweetLightStyle);
            viewHolder.ctv.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
            layout.addView(viewHolder.ctv); */
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ImageLoader il = ImageLoader.getInstance();
        viewHolder.image.setImageResource(android.R.color.transparent); // clear image
        il.displayImage(t.user.profileImageUrl, viewHolder.image);
        if (t.entities.media != null) {
            viewHolder.embeddedImage.setVisibility(View.VISIBLE);
            viewHolder.embeddedImage.setImageResource(android.R.color.transparent); // clear image
            il.displayImage(((LinkedTreeMap<String, String>) t.entities.media.get(0)).get("media_url"), viewHolder.embeddedImage);
        } else {
            viewHolder.embeddedImage.setVisibility(View.GONE);
        }
        viewHolder.screen.setText(t.user.screenName);
        viewHolder.user.setText("@" + t.user.name);
        viewHolder.timestamp.setText(DateUtility.twitterTime(t.createdAt, context));
        viewHolder.body.setText(t.text);
        viewHolder.body.setAutoLinkMask(Linkify.WEB_URLS);

        // Return the completed view to render on screen
        return convertView;
    }


    private static class ViewHolder {
        ImageView image;
        TextView screen;
        TextView user;
        TextView timestamp;
        TextView body;
        ImageView embeddedImage;
    }


    private boolean checkForImage(String text) {
        Pattern p = Pattern.compile("\\s*http\\S+\\s*");
        Matcher m = p.matcher(text);
        ArrayList<String> list = new ArrayList<String>();
        while (m.find()) { // Find each match in turn; String can't do this.
            list.add(m.group(0));
        }
        return list.size() > 1;
    }


}