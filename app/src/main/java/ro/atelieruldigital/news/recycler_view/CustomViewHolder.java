package ro.atelieruldigital.news.recycler_view;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ro.atelieruldigital.news.R;

class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView mTextView;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        mTextView = itemView.findViewById(R.id.text_view);
    }
}
