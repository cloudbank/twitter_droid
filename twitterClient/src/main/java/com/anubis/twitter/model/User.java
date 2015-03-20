package com.anubis.twitter.model;

import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;

@Table(name = "Users")
public class User implements Serializable {
	@Column
	private String name;
	@Column(name = "remoteid", unique = true)
	private long id;
	@Column
	private String screen_name;
	@Column
	private String profile_image_url;
	private String followers_count;
	private String following;
	private String tagline;

	public User() {
		super();
	}

	/*
	 * public List<Tweet> tweets() { return getMany(Tweet.class, "User"); }
	 */
/*
	public static User fromJson(JSONObject jo) {
		User u = new User();
		try {
			u.name = jo.getString("name");
			u.id = jo.getLong("id");
			u.screenName = jo.getString("screenName");
			u.profileImageUrl = jo.getString("profile_image_url");
			u.followers = jo.getString("followers_count");
			u.following = jo.getString("friends_count");
			u.tagline = jo.getString("description");
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		return u;

	}
*/
	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public String getScreenName() {
		return screen_name;
	}

	public String getProfileImageUrl() {
		return profile_image_url;
	}

	public String getFollowing() {
		return following;

	}

	public String getFollowers() {
		return followers_count;
	}

	public String getTagline() {
		return tagline;
	}

}
