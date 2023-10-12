package com.example.assignment2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class TickerListFragment extends Fragment {
    LinkedList<String> tickerList= new LinkedList<>();
    ListView list;
    public TickerListFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tickerList = new LinkedList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_ticker_list, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1);
        list  = view.findViewById(R.id.list_view);
        list.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }
}