package com.example.project;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewHolder extends RecyclerView.Adapter<RecyclerViewHolder.ViewHolder>{

    public ArrayList<JsonItems> items;
    private LayoutInflater layoutInflater;

    public RecyclerViewHolder(Context context, ArrayList<JsonItems> listOfItems) {
        this.layoutInflater = LayoutInflater.from(context);
        this.items = listOfItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerviewitem, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getTextViewName().setText(items.get(position).toStringName());
        holder.getTextViewID().setText(items.get(position).toStringID());
        holder.getTextViewLocation().setText(items.get(position).toStringLocation());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView textViewName;
        private final TextView textViewID;
        private final TextView textViewLocation;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.RecyclerViewItemName);
            textViewID = itemView.findViewById(R.id.RecyclerViewItemID);
            textViewLocation = itemView.findViewById(R.id.RecyclerViewItemLocation);
        }

        public TextView getTextViewName() {
            return textViewName;
        }

        public TextView getTextViewID() {
            return textViewID;
        }

        public TextView getTextViewLocation() {
            return textViewLocation;
        }
    }
}
