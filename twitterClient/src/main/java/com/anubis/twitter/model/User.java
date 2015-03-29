package com.anubis.twitter.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Table;

import java.io.Serializable;

@Table(name = "Users")
public class User extends Model implements Serializable {
    //@todo use parecelable library
   /*
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
*/

    public User() {
        super();

    }
    public static final long INVALID_ID = -1L;
    @com.google.gson.annotations.SerializedName("contributors_enabled")
    public  boolean contributorsEnabled;
    @com.google.gson.annotations.SerializedName("created_at")
    public  java.lang.String createdAt;
    @com.google.gson.annotations.SerializedName("default_profile")
    public  boolean defaultProfile;
    @com.google.gson.annotations.SerializedName("default_profile_image")
    public  boolean defaultProfileImage;
    @com.google.gson.annotations.SerializedName("description")
    public  java.lang.String description;
    @com.google.gson.annotations.SerializedName("email")
    public  java.lang.String email;
    @com.google.gson.annotations.SerializedName("entities")
    public  com.twitter.sdk.android.core.models.UserEntities entities;
    @com.google.gson.annotations.SerializedName("favourites_count")
    public  int favouritesCount;
    @com.google.gson.annotations.SerializedName("follow_request_sent")
    public  boolean followRequestSent;
    @com.google.gson.annotations.SerializedName("followers_count")
    public  int followersCount;
    @com.google.gson.annotations.SerializedName("friends_count")
    public  int friendsCount;
    @com.google.gson.annotations.SerializedName("geo_enabled")
    public  boolean geoEnabled;
    @com.google.gson.annotations.SerializedName("id")
    public  long id;
    @com.google.gson.annotations.SerializedName("id_str")
    public  java.lang.String idStr;
    @com.google.gson.annotations.SerializedName("is_translator")
    public  boolean isTranslator;
    @com.google.gson.annotations.SerializedName("lang")
    public  java.lang.String lang;
    @com.google.gson.annotations.SerializedName("listed_count")
    public  int listedCount;
    @com.google.gson.annotations.SerializedName("location")
    public  java.lang.String location;
    @com.google.gson.annotations.SerializedName("name")
    public  java.lang.String name;
    @com.google.gson.annotations.SerializedName("profile_background_color")
    public  java.lang.String profileBackgroundColor;
    @com.google.gson.annotations.SerializedName("profile_background_image_url")
    public  java.lang.String profileBackgroundImageUrl;
    @com.google.gson.annotations.SerializedName("profile_background_image_url_https")
    public  java.lang.String profileBackgroundImageUrlHttps;
    @com.google.gson.annotations.SerializedName("profile_background_tile")
    public  boolean profileBackgroundTile;
    @com.google.gson.annotations.SerializedName("profile_banner_url")
    public  java.lang.String profileBannerUrl;
    @com.google.gson.annotations.SerializedName("profile_image_url")
    public  java.lang.String profileImageUrl;
    @com.google.gson.annotations.SerializedName("profile_image_url_https")
    public  java.lang.String profileImageUrlHttps;
    @com.google.gson.annotations.SerializedName("profile_link_color")
    public  java.lang.String profileLinkColor;
    @com.google.gson.annotations.SerializedName("profile_sidebar_border_color")
    public  java.lang.String profileSidebarBorderColor;
    @com.google.gson.annotations.SerializedName("profile_sidebar_fill_color")
    public  java.lang.String profileSidebarFillColor;
    @com.google.gson.annotations.SerializedName("profile_text_color")
    public  java.lang.String profileTextColor;
    @com.google.gson.annotations.SerializedName("profile_use_background_image")
    public  boolean profileUseBackgroundImage;
    @com.google.gson.annotations.SerializedName("protected")
    public  boolean protectedUser;
    @com.google.gson.annotations.SerializedName("screen_name")
    public  java.lang.String screenName;
    @com.google.gson.annotations.SerializedName("show_all_inline_media")
    public  boolean showAllInlineMedia;
    @com.google.gson.annotations.SerializedName("status")
    public  Tweet status;
    @com.google.gson.annotations.SerializedName("statuses_count")
    public  int statusesCount;
    @com.google.gson.annotations.SerializedName("time_zone")
    public  java.lang.String timeZone;
    @com.google.gson.annotations.SerializedName("url")
    public  java.lang.String url;
    @com.google.gson.annotations.SerializedName("utc_offset")
    public  int utcOffset;
    @com.google.gson.annotations.SerializedName("verified")
    public  boolean verified;
    @com.google.gson.annotations.SerializedName("withheld_in_countries")
    public  java.lang.String withheldInCountries;
    @com.google.gson.annotations.SerializedName("withheld_scope")
    public  java.lang.String withheldScope;


    public User(boolean contributorsEnabled, java.lang.String createdAt, boolean defaultProfile, boolean defaultProfileImage, java.lang.String description, java.lang.String emailAddress, com.twitter.sdk.android.core.models.UserEntities entities, int favouritesCount, boolean followRequestSent, int followersCount, int friendsCount, boolean geoEnabled, long id, java.lang.String idStr, boolean isTranslator, java.lang.String lang, int listedCount, java.lang.String location, java.lang.String name, java.lang.String profileBackgroundColor, java.lang.String profileBackgroundImageUrl, java.lang.String profileBackgroundImageUrlHttps, boolean profileBackgroundTile, java.lang.String profileBannerUrl, java.lang.String profileImageUrl, java.lang.String profileImageUrlHttps, java.lang.String profileLinkColor, java.lang.String profileSidebarBorderColor, java.lang.String profileSidebarFillColor, java.lang.String profileTextColor, boolean profileUseBackgroundImage, boolean protectedUser, java.lang.String screenName, boolean showAllInlineMedia, Tweet status, int statusesCount, java.lang.String timeZone, java.lang.String url, int utcOffset, boolean verified, java.lang.String withheldInCountries, java.lang.String withheldScope) { /* compiled code */ }

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

    /*public long getId() {
        return id;
    }*/

    public String getScreenName() {
        return screenName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public int getFollowing() {
        return friendsCount;

    }

    public int getFollowers() {
        return followersCount;
    }


}
