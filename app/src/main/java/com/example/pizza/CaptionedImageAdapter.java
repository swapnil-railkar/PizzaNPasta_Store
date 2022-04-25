package com.example.pizza;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/*
  Adapter class for captioned images showing names of pizzas and pastas in application along with
  images for same.The adapter has two main jobs: to create each of the views that are visible
  within the recycler view, and to bind each view to a piece of data. For more detail comments, refer
  BillAdapter.java class
 */

class CaptionedImageAdapter extends RecyclerView.Adapter<CaptionedImageAdapter.ViewHolder> {

    private String[] captions;
    private int[] imageId;
    private Listener listener;

    interface Listener {
        void onClick(int position);
    }

    public CaptionedImageAdapter(String[] captions, int[] imageId) {
        this.captions = captions;
        this.imageId = imageId;
    }

    /*
    Inner class representing attributes of a single view.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;

        public ViewHolder(@NonNull CardView itemView) {
            super(itemView);
            cardView = itemView;
        }
    }

    @NonNull
    @Override
    public CaptionedImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_captioned_image, parent, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull CaptionedImageAdapter.ViewHolder holder, final int position) {
        /*
        Called by RecyclerView to display the data at the specified position.
         */
        final CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.info_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageId[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[position]);
        TextView textView = (TextView) cardView.findViewById(R.id.info_text);
        textView.setText(captions[position]);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        /*
        returns total items in recycler view.
         */
        return captions.length;
    }

    /*
    Listener to react to click event.
     */
    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
