package com.example.wheregottimefind;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

 

public class ReviewImagesAdaptor extends RecyclerView.Adapter<ReviewImagesAdaptor.ReviewViewHolder> {

    String[] iProductImages;

    float screen_width;

    Context context;

    public ReviewImagesAdaptor(Context page, String[] ProductImages){
        this.context = page;
        this.iProductImages = ProductImages;
    }





    //RecyclerView calls this method whenever it needs to create a new ViewHolder.
    //The method creates and initializes the ViewHolder and its associated View,
    //but does not fill in the view's contents—the ViewHolder has not yet been bound to
    //specific data.

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.review_box_template, parent, false);

        screen_width = view.getWidth();

        return new ReviewViewHolder(view);
    }




    //RecyclerView calls this method to associate a ViewHolder with data. The method fetches the appropriate data
    //and uses the data to fill in the view holder's layout.
    //For example, if the RecyclerView displays a list of names,
    //the method might find the appropriate name in the list and fill in the view holder's
    //TextView widget.
    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {

        final String NIL = "NIL";

        String unitText, unitsPurchasedText, PricePerUnitText, product_nameText;
        String reviewsByUsernameText;


        try{
            if (iProductImages == null) {
                byte[] decodedString = Base64.decode(iProductImages[position], Base64.DEFAULT);
                Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                holder.GiantProductImage.setImageBitmap(decodedByte);
            }
            else throw new IndexOutOfBoundsException();

        }
        catch(IndexOutOfBoundsException ex){
            holder.GiantProductImage.setImageResource(R.drawable.blank);
        }

    }





    //RecyclerView calls this method to get the size of the data set.
    //For example, in an address book app, this might be the total number of addresses.
    //RecyclerView uses this to determine when there are no more items that can be displayed.

    @Override
    public int getItemCount() {

        return iProductImages.length;

    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder{

        ImageView GiantProductImage;



        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);

            GiantProductImage = itemView.findViewById(R.id.GiantProductImage);


        }

    }


}
