package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private List<String> mDataset;
    private List<String> mDataset2;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public TextView mAuthorTextView;

        public MyViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.my_text_view);
            mAuthorTextView = v.findViewById(R.id.my_author_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle toDashboard = new Bundle();
                    toDashboard.putString("BookName", mTextView.getText().toString());
                    Navigation.findNavController(v).navigate(R.id.navigation_dashboard, toDashboard);
                }
            });
        }
    }


    public MyRecyclerViewAdapter(List<String> myDataset,List<String> myDataset2) {
        mDataset = myDataset;
        mDataset2 = myDataset2;
    }

    @Override
    public MyRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextView.setText(mDataset.get(position));
        holder.mAuthorTextView.setText(mDataset2.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}