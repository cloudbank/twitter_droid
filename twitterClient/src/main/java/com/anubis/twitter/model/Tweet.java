package com.anubis.twitter.model;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Column.ForeignKeyAction;
import com.activeandroid.annotation.Table;

import java.io.Serializable;

@Table(name = "Tweets")
public class Tweet implements Serializable{
	@Column
	private String text;
	@Column(name="remoteid", unique = true)
	private long id;
	@Column
	private String createdAt;
	@Column(name="User", onUpdate = ForeignKeyAction.CASCADE, onDelete = ForeignKeyAction.CASCADE)
	private User user;

	
	public Tweet() {
		super();
	}
	/*
	public static Tweet fromJson(JSONObject jo) {
		Tweet tweet = new Tweet();
		try {
			tweet.body = Html.fromHtml(jo.getString("text")).toString();
			
			tweet.id = jo.getLong("id");
			tweet.createdAt = jo.getString("created_at");
			
			tweet.user = User.fromJson(jo.getJSONObject("user"));

		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		return tweet;

	}
&*/
	public String getText() {

		return text;
	}

	public long getId() {
		return id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public User getUser() {
		return user;
	}
/*
	public static ArrayList<Tweet> fromJsonArray(JSONArray response) {
		ArrayList<Tweet> twts = new ArrayList<Tweet>();
		for (int i = 0; i < response.length(); i++) {
			JSONObject jo = null;
			try {
				jo = response.getJSONObject(i);

			} catch (JSONException e) {
				e.printStackTrace();
				continue;
			}
			Tweet t = Tweet.fromJson(jo);
			
			if (null != t) {
				twts.add(t);
			}
		}
	
		return twts;
	}
*/
	@Override
	public String toString() {
        return this.text  + "   --"+this.user.getName()+" :"+this.user.getScreenName();
	}
}
