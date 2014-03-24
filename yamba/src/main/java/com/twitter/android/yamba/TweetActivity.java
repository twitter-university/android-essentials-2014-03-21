package com.twitter.android.yamba;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TweetActivity extends Activity
        implements View.OnClickListener {

    private static final String TAG = "TweetActivity";
    EditText mEditMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate() invoked");

        setContentView(R.layout.activity_tweet);

        mEditMsg = (EditText) findViewById(R.id.edit_msg);
        Button buttonTweet = (Button) findViewById(R.id.button_tweet);
        buttonTweet.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button_tweet:
                if (BuildConfig.DEBUG) Log.d(TAG, "Tweet button clicked");

                String msg = mEditMsg.getText().toString();
                if (!TextUtils.isEmpty(msg)) {
                    Log.d(TAG, "User entered: " + msg);
                    mEditMsg.setText("");
                }
            default:
                // Unknown button clicked?
                Log.w(TAG, "What was that?");
        }
    }
}
