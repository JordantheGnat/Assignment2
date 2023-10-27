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
        mainV = inflater.inflate(R.layout.fragment_info_web, container, false);
        displayWeb(mainUrl);
        Intent mainIntent = getActivity().getIntent();
        String smsMsg = mainIntent.getStringExtra("sms");
        String urlKey = mainUrl+smsMsg;
        Intent intent = getActivity().getIntent();//intent to check for sms


        return mainV;
    }
    public void displayWeb(String link){
        //https://stackoverflow.com/questions/31159149/using-webview-in-fragment
        WebView seekAlphWV= mainV.findViewById(R.id.web_view);//
        WebSettings webSettings = seekAlphWV.getSettings();
        webSettings.setJavaScriptEnabled(true);
        seekAlphWV.loadUrl(link);
        seekAlphWV.setWebViewClient(new WebViewClient());
    }
}