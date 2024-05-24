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
        holder.getTextViewID().setText("ID: " + items.get(position).toStringID());
        holder.getTextViewName().setText(items.get(position).toStringName());
        holder.getTextViewLogin().setText(items.get(position).toStringLogin());
        holder.getTextViewLocation().setText("Location: " + items.get(position).toStringLocation());
        holder.getTextViewSize().setText("Area: " + items.get(position).toStringSize() + "km²");
        holder.getTextViewCost().setText("Volume: " + items.get(position).toStringCost() + "km³");
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView textViewID;

        private final TextView textViewName;

        private final TextView textViewLogin;

        private final TextView textViewLocation;

        private final TextView textViewSize;

        private final TextView textViewCost;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.RecyclerViewItemID);
            textViewName = itemView.findViewById(R.id.RecyclerViewItemName);
            textViewLogin = itemView.findViewById(R.id.RecyclerViewItemLogin);
            textViewLocation = itemView.findViewById(R.id.RecyclerViewItemLocation);
            textViewSize = itemView.findViewById(R.id.RecyclerViewItemArea);
            textViewCost = itemView.findViewById(R.id.RecyclerViewItemVolume);
        }

        public TextView getTextViewID() {
            return textViewID;
        }

        public TextView getTextViewName() {
            return textViewName;
        }

        public TextView getTextViewLogin(){
            return textViewLogin;
        }

        public TextView getTextViewLocation() {
            return textViewLocation;
        }

        public TextView getTextViewSize(){
            return textViewSize;
        }

        public TextView getTextViewCost(){
            return textViewCost;
        }
    }
}
