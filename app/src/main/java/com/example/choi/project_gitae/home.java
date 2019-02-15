package com.example.choi.project_gitae;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class home extends Fragment implements ServerResponse {

    private ImageButton btn_my_list;
    private ImageButton btn_search_book;
    private RecyclerView recyclerView;
    private LinearLayoutManager llm;
    private RecyclerViewAdapter recyclerViewAdapter;

    List<Compo> compo = new ArrayList<>();


    public home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        btn_my_list = root.findViewById(R.id.btn_my_list);
        btn_search_book = root.findViewById(R.id.btn_search_book);
        recyclerView = root.findViewById(R.id.recyler);
        llm = new LinearLayoutManager(getActivity());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), llm.getOrientation()));
        recyclerView.setLayoutManager(llm);


        HashMap<String, String> parameter = new HashMap<>();
        parameter.put("key", "7EF192D7C7D2600470252980FD233757C69B747264C145A0255E78ADB51650F9");
        parameter.put("query", "python");
        parameter.put("output", "json");
        new Server().onDb("http://book.interpark.com/api/search.api", parameter, this);


        return root;

    }


    @Override
    public void processFinish(String output) {
        try {
            JSONObject objChannel = new JSONObject(output);
            JSONArray arrItem = objChannel.getJSONArray("item");
//            String strImage = arrItem.getJSONObject(0).getString("coverLargeUrl");

            for (int i = 0; i < arrItem.length(); i++)
                compo.add(new Compo(String.valueOf(arrItem.getJSONObject(i).get("coverLargeUrl")),
                        arrItem.getJSONObject(i).getString("title"),
                        arrItem.getJSONObject(i).getString("priceStandard")
                        ));
            recyclerViewAdapter = new RecyclerViewAdapter(getActivity(), compo);
            recyclerView.setAdapter(recyclerViewAdapter);


        } catch (JSONException e1) {
            e1.printStackTrace();
        }


    }
}
