package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {

    TextView bookName;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
/*
        bookName = rootView.findViewById(R.id.nameBook);
        try {
            bookName.setText(getArguments().getString("BookName"));
        }
        catch(Exception a) {}
*/



        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String url1 = "https://raw.githubusercontent.com/Lpirskaya/JsonLab/master/Books2022.json";
                URL url = null;
                try {
                    url = new URL(url1);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                HttpURLConnection conn = null;
                try {
                    conn = (HttpURLConnection) url.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try{
                    if (conn.getResponseCode() == HttpURLConnection.HTTP_OK){

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.i("Thread", "IsRunning");

                StringBuilder response = new StringBuilder();
                BufferedReader input = null;
                try {
                    input = new BufferedReader(
                            new InputStreamReader(conn.getInputStream()), 8192);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.i("Thread", "IsRunning");
                String line = null;

                try {
                    while ((line = input.readLine()) != null){
                        response.append(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String resp = response.toString();

                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<Books>>() {}.getType();
                List<Books> books = gson.fromJson(resp, listType);
                for (int i = 0; i < books.size(); ++i){
                    Log.i(Integer.toString(i), books.get(i).getName());
                }
            }
        });

        thread.start();


        return rootView;
    }
}



