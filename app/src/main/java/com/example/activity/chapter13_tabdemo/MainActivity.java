package com.example.activity.chapter13_tabdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("tag1");

        spec.setContent(R.id.tab1);
        spec.setIndicator("Clock");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("tag2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Button");
        tabHost.addTab(spec);
    }
}
