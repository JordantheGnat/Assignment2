package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    FragmentManager fg;
    public TickerListFragment tickListFrag;
    public InfoWebFragment infoWebFrag;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fg=getSupportFragmentManager();
        setContentView(R.layout.activity_main);
        Intent currIntent = getIntent();
        currIntent.getStringExtra("sms");
        tickListFrag = new TickerListFragment();
        infoWebFrag = new InfoWebFragment();
        tickListFrag.addTicker("GME");
        if (savedInstanceState == null) {
            fg.beginTransaction().replace(R.id.TickFragContain, new TickerListFragment()).replace(R.id.WebFragContain, new InfoWebFragment()).commit();
                    //new ColorPickFragment()).replace(R.id.bottomContainer, new HistoryFragment()).commit();

        }

    }

}