package com.anubis.twitter.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Table(name = "Tweets")
public class Tweet extends Model implements Serializable {
    /* @Column
     private String text;
     @Column(name = "remoteid", unique = true)
     private long id;
     @Column
     private String createdAt;
     @Column(name = "User", onUpdate = ForeignKeyAction.CASCADE, onDelete = ForeignKeyAction.CASCADE)
     private User user;
 */
    public Tweet() {
        super();
    }

    // @com.google.gson.annotations.SerializedName("coordinates")
    // public final com.twitter.sdk.android.core.models.Coordinates coordinates;
    @com.google.gson.annotations.SerializedName("entities")
    public Entities entities;
    @SerializedName("created_at")
    public java.lang.String createdAt;
    @com.google.gson.annotations.SerializedName("current_user_retweet")
    public java.lang.Object currentUserRetweet;
    //@com.google.gson.annotations.SerializedName("entities")
    // public  TweetEntities entities;
    @com.google.gson.annotations.SerializedName("favorite_count")
    public java.lang.Integer favoriteCount;
    @com.google.gson.annotations.SerializedName("favorited")
    public boolean favorited;
    @com.google.gson.annotations.SerializedName("filter_level")
    public java.lang.String filterLevel;
    @com.google.gson.annotations.SerializedName("id")
    public long id;
    @com.google.gson.annotations.SerializedName("id_str")
    public java.lang.String idStr;
    @com.google.gson.annotations.SerializedName("in_reply_to_screen_name")
    public java.lang.String inReplyToScreenName;
    @com.google.gson.annotations.SerializedName("in_reply_to_status_id")
    public long inReplyToStatusId;
    @com.google.gson.annotations.SerializedName("in_reply_to_status_id_str")
    public java.lang.String inReplyToStatusIdStr;
    @com.google.gson.annotations.SerializedName("in_reply_to_user_id")
    public long inReplyToUserId;
    @com.google.gson.annotations.SerializedName("in_reply_to_user_id_str")
    public java.lang.String inReplyToUserIdStr;
    @com.google.gson.annotations.SerializedName("lang")
    public java.lang.String lang;
    // @com.google.gson.annotations.SerializedName("place")
    //public  com.twitter.sdk.android.core.models.Place place;
    @com.google.gson.annotations.SerializedName("possibly_sensitive")
    public boolean possiblySensitive;
    @com.google.gson.annotations.SerializedName("scopes")
    public java.lang.Object scopes;
    @com.google.gson.annotations.SerializedName("retweet_count")
    public int retweetCount;
    @com.google.gson.annotations.SerializedName("retweeted")
    public boolean retweeted;
    // @com.google.gson.annotations.SerializedName("retweeted_status")
    //public  Tweet retweetedStatus;
    @com.google.gson.annotations.SerializedName("source")
    public java.lang.String source;
    @SerializedName("text")
    public java.lang.String text;
    @com.google.gson.annotations.SerializedName("truncated")
    public boolean truncated;
    @com.google.gson.annotations.SerializedName("user")
    public User user;
    @com.google.gson.annotations.SerializedName("withheld_copyright")
    public boolean withheldCopyright;
    @com.google.gson.annotations.SerializedName("withheld_in_countries")
    public java.util.List<java.lang.String> withheldInCountries;
    @com.google.gson.annotations.SerializedName("withheld_scope")
    public java.lang.String withheldScope;

    //public Tweet(com.twitter.sdk.android.core.models.Coordinates coordinates, java.lang.String createdAt, java.lang.Object currentUserRetweet, TweetEntities entities, java.lang.Integer favoriteCount, boolean favorited, java.lang.String filterLevel, long id, java.lang.String idStr, java.lang.String inReplyToScreenName, long inReplyToStatusId, java.lang.String inReplyToStatusIdStr, long inReplyToUserId, java.lang.String inReplyToUserIdStr, java.lang.String lang, com.twitter.sdk.android.core.models.Place place, boolean possiblySensitive, java.lang.Object scopes, int retweetCount, boolean retweeted, Tweet retweetedStatus, java.lang.String source, java.lang.String text, boolean truncated, com.twitter.sdk.android.core.models.User user, boolean withheldCopyright, java.util.List<java.lang.String> withheldInCountries, java.lang.String withheldScope) { /* compiled code */ }

    //  public boolean equals(java.lang.Object o) { /* compiled code */ }

    //  public int hashCode() { /* compiled code */ }
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

   /* public long getId() {
        return id;
    }*/

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
        return this.getText() + "   --" + this.getUser().getName() + " :" + this.getUser().getScreenName();
    }
}
