package com.example.project;

import android.annotation.SuppressLint;
import android.content.Context;
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

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getTextViewTime().setText("Tid: " + items.get(position).toStringTime());
        holder.getTextViewName().setText(items.get(position).toStringName());
        holder.getTextViewLocation().setText("Plats: " + items.get(position).toStringLocation());
        holder.getTextViewPlayers().setText("Spelare: " + items.get(position).toStringPlayers());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView textViewTime;

        private final TextView textViewName;

        private final TextView textViewLocation;

        private final TextView textViewPlayers;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewTime = itemView.findViewById(R.id.RVITime);
            textViewName = itemView.findViewById(R.id.RVIName);
            textViewLocation = itemView.findViewById(R.id.RVILocation);
            textViewPlayers = itemView.findViewById(R.id.RVIPlayers);
        }

        public TextView getTextViewTime() {
            return textViewTime;
        }

        public TextView getTextViewName() {
            return textViewName;
        }

        public TextView getTextViewLocation() {
            return textViewLocation;
        }

        public TextView getTextViewPlayers(){
            return textViewPlayers;
        }
    }
}
