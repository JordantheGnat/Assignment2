package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    FragmentManager fg;
    @Override




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fg=getSupportFragmentManager();
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            fg.beginTransaction().replace(R.id.topContainer,
                    new TickerListFragment()).replace(R.id.bottomContainer, new InfoWebFragment()).commit();
                    //new ColorPickFragment()).replace(R.id.bottomContainer, new HistoryFragment()).commit();
        }
    }
}