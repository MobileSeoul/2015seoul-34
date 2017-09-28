package com.example.administrator.festival;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;


public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //final Intent intent = new Intent(SGProjectActivity.this, StartMain.class);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //startActivity(intent);
                startActivity(new Intent(MainActivity.this, Startmain.class));
                finish();
            }
        };
        handler.sendEmptyMessageDelayed(0, 3000);
    }
}

