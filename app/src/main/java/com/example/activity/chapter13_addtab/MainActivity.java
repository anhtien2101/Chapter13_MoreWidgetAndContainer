package com.example.activity.chapter13_addtab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
    TabHost tabs;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.tabButton);
        tabs = (TabHost) findViewById(R.id.tabHost);
        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("tagButton");
        spec.setContent(R.id.tabButton);
        spec.setIndicator("Button");
        tabs.addTab(spec);

        // When click button, new tab was added
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTab();
            }
        });

    }

    public void addTab(){
        TabHost.TabSpec spec = tabs.newTabSpec("tag1");
        spec.setContent(new TabHost.TabContentFactory() {
            @Override
            public View createTabContent(String s) {
                return new AnalogClock(MainActivity.this);
            }
        });

        spec.setIndicator("Clock");
        tabs.addTab(spec);
    }
}
