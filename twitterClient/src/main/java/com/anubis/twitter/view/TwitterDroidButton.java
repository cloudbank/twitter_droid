package com.anubis.twitter.view;

import android.content.Context;
import android.util.AttributeSet;

import com.anubis.twitter.R;
import com.anubis.twitter.TwitterApp;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class TwitterDroidButton extends TwitterLoginButton {
    public TwitterDroidButton(Context context) {
        super(context);
        init();
    }

    public TwitterDroidButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TwitterDroidButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        if (isInEditMode()) {
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable
                .ic_twitter_login), null, null, null);
        setBackgroundResource(R.drawable.sign_up_button);
        setTextSize(20);
        setPadding(30, 0, 10, 0);
        setTextColor(getResources().getColor(R.color.tw__blue_default));
        setTypeface(TwitterApp.getInstance().getTypeface());
    }

}
