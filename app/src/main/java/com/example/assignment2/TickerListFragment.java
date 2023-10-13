package com.example.assignment2;

import android.content.Intent;
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
import android.widget.Toast;

import java.util.LinkedList;

public class TickerListFragment extends Fragment {
    LinkedList<String> tickerList= new LinkedList<>();
    ListView tickerLv;
    String[] tickerNames = {"BAC","AAPL","DIS"};
    String[] tickerLinks = {"https://seekingalpha.com/symbol/BAC","https://seekingalpha.com/symbol/AAPL",
        "https://seekingalpha.com/symbol/DIS"};
    public TickerListFragment() {
        // Required empty public constructor
    }
    private View.OnClickListener lvListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            view.getContext();
        }
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tickerList = new LinkedList<>();

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
                Uri uri = Uri.parse(tickerLinks[i]);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        return view;
    }
}
    /*public void addTicker(String newTick){
        tickerList.add(newTick);
        //HistoryFragment hf  = this.();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,tickerList);
        tickerLv.setAdapter(adapter);
    }
}*/