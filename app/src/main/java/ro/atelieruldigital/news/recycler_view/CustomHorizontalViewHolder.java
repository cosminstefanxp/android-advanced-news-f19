package ro.atelieruldigital.news.recycler_view;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ro.atelieruldigital.news.R;

class CustomHorizontalViewHolder extends RecyclerView.ViewHolder {
    TextView mTextViewTitle;
    TextView mTextViewDescription;

    public CustomHorizontalViewHolder(@NonNull View itemView) {
        super(itemView);

        initView(itemView);
    }

    private void initView(View itemView) {
        mTextViewTitle = itemView.findViewById(R.id.text_view_title);
        mTextViewDescription = itemView.findViewById(R.id.text_view_description);
    }
}