package com.example.assignment2;

import android.content.Intent;
import android.icu.text.IDNA;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TickerListFragment extends Fragment {
    ListView tickerLv;
    InfoWebFragment idkMan =  new InfoWebFragment();
    String[] tickerNames = {"BAC","AAPL","DIS","","",};
    String[] tickerLinks = {"https://seekingalpha.com/symbol/BAC","https://seekingalpha.com/symbol/AAPL",
        "https://seekingalpha.com/symbol/DIS","",""};
    public TickerListFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_ticker_list, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,tickerNames);
        //this /\ uses the created String[], adapts it, adds it to the tickerLv which is then displayed
        tickerLv  = view.findViewById(R.id.list_view);

        tickerLv.setAdapter(adapter);
        // Inflate the layout for this fragment
        tickerLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*Uri uri = Uri.parse(tickerLinks[i]);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);//    opens web page
                startActivity(intent);*/
                idkMan.displayWeb(tickerLinks[i]);

            }
        });
        return view;
    }
    public void addTicker(String newTick){//adds ticker to the list, if its

        for(int i = 0; tickerNames.length >= i; i++){
                if(tickerNames[i]==""){
                    tickerHelper(newTick,i);
                    break;

                } else if (i>=tickerNames.length) {
                    tickerHelper(newTick,0);
                    break;
                }
        }
    }
    public void tickerHelper(String newTick,int index){
        //unnecessary but I wanted it to be easier
        tickerNames[index]=newTick;
        tickerLinks[index]="https://seekingalpha.com/symbol/" + newTick;
        Log.i("console","added "+newTick);
    }
}