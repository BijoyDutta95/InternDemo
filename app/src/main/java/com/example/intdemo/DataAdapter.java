package com.example.intdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<DataModel> dataList=new ArrayList<>();
    private Context context;
    public DataAdapter(Context context, ArrayList<DataModel> dataModels){
        this.dataList=dataModels;
        this.context=context;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_block,parent,false);
        return new DataAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        holder.block_ID.setText(Integer.toString(dataList.get(position).getId()));
        holder.block_Title.setText(dataList.get(position).getTitle());

        Picasso.get().load(dataList.get(position).getThumbnailUrl()).into(holder.blockImage);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView blockImage;
        private TextView block_ID,block_Title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            blockImage=(ImageView)itemView.findViewById(R.id.dataImage);
            block_ID=(TextView)itemView.findViewById(R.id.block_ID);
            block_Title=(TextView)itemView.findViewById(R.id.block_Title);
        }
    }
}
