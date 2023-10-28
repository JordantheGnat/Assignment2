package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class InfoWebFragment extends Fragment {
    public View mainV;

    public InfoWebFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String mainUrl = "https://seekingalpha.com/";
        WebView seekAlphWV;
        mainV = inflater.inflate(R.layout.fragment_info_web, container, false);
        displayWeb(mainUrl,mainV);
        Intent mainIntent = getActivity().getIntent();
        String smsMsg = mainIntent.getStringExtra("sms");
        String urlKey = mainUrl+smsMsg;
        Intent intent = getActivity().getIntent();//intent to check for sms


        return mainV;
    }
    public void displayWeb(String link, View tempView){
        WebView seekAlphWV;
        //https://stackoverflow.com/questions/31159149/using-webview-in-fragment
        if(tempView==mainV){
            seekAlphWV = mainV.findViewById(R.id.web_view);
        }else{seekAlphWV = tempView.findViewById(R.id.web_view);}
        ;//for some reason apparently this only works on first startup, not upon re-creation for
        //clicking links. Tried a bunch of things, nothing worked, so I am going to pretend like it does for the sake of my own sanity.

        WebSettings webSettings = seekAlphWV.getSettings();
        seekAlphWV.setWebViewClient(new WebViewClient());
        webSettings.setJavaScriptEnabled(true);
        seekAlphWV.loadUrl(link);

    }
}