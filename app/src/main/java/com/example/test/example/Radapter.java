package com.example.test.example;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.test.R;

import java.util.ArrayList;

public class Radapter extends RecyclerView.Adapter<Radapter.ViewHolder> {

    private ArrayList<Item> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    Context ctx;

    // data is passed into the constructor
    public Radapter(Context context, ArrayList<Item> data,Context ctx) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.ctx=ctx;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.itemlist, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       /* String animal = mData.get(position);
        holder.myTextView.setText(animal);*/
        holder.name.setText(mData.get(position).getName());

        Glide
                .with(ctx)
                .load(mData.get(position).getUrl())
                .centerCrop()
                .placeholder(R.drawable.testimg)
                .into( holder.main_image);

        if(mData.get(position).getRating()>=1){
            Glide
                    .with(ctx)
                    .load(R.drawable.star_green)
                    .centerCrop()

                    .into( holder.image1);
        }
        if(mData.get(position).getRating()>=2){
            Glide
                    .with(ctx)
                    .load(R.drawable.star_green)
                    .centerCrop()

                    .into( holder.image2);
        }
        if(mData.get(position).getRating()>=3){
            Glide
                    .with(ctx)
                    .load(R.drawable.star_green)
                    .centerCrop()

                    .into( holder.image3);
        }
        if(mData.get(position).getRating()>=4){
            Glide
                    .with(ctx)
                    .load(R.drawable.star_green)
                    .centerCrop()

                    .into( holder.image4);
        }
        if(mData.get(position).getRating()>=5){
            Glide
                    .with(ctx)
                    .load(R.drawable.star_green)
                    .centerCrop()

                    .into( holder.image5);
        }

        holder.rating_size.setText("("+String.valueOf(mData.get(position).getRating_size())+")");
        holder.price.setText("$ "+String.valueOf(mData.get(position).getPrice()));
        if(mData.get(position).getOld_price()>0){
            holder.old_price.setText("$ "+String.valueOf(mData.get(position).getOld_price()));
            holder.old_price.setPaintFlags( holder.old_price.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
       // TextView myTextView;
       TextView name;
       ImageView main_image;
        ImageView image1;
        ImageView image2;
        ImageView image3;
        ImageView image4;
        ImageView image5;

        TextView rating_size;
        TextView price;
        TextView old_price;
        ViewHolder(View itemView) {
            super(itemView);
          //  myTextView = itemView.findViewById(R.id.tvAnimalName);
            name=itemView.findViewById(R.id.textView5);
            main_image=itemView.findViewById(R.id.imageView6);

            image1=itemView.findViewById(R.id.imageView8);
            image2=itemView.findViewById(R.id.imageView9);
            image3=itemView.findViewById(R.id.imageView10);
            image4=itemView.findViewById(R.id.imageView11);
            image5=itemView.findViewById(R.id.imageView12);
            rating_size=itemView.findViewById(R.id.textView7);
            price=itemView.findViewById(R.id.textView6);

            old_price=itemView.findViewById(R.id.textView9);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
   /* String getItem(int id) {
        return mData.get(id);
    }*/

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
