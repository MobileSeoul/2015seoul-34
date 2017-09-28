package com.example.administrator.festival;

/**
 * Created by Administrator on 2015-10-30.
 */
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class Test extends Activity implements OnClickListener {
    Startmain s= new Startmain();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

    }

    public void onClick(View v) {

        switch (v.getId()) {

        }
    }
}
