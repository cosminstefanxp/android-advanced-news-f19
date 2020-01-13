package ro.atelieruldigital.news.recycler_view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ro.atelieruldigital.news.R;
import ro.atelieruldigital.news.model.ArticleResponse;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private ArrayList<ArticleResponse.Article> mArticleList;

    public CustomAdapter (ArrayList<ArticleResponse.Article> articleList) {
        this.mArticleList = articleList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_news_card,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.mTextView.setText(mArticleList.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return mArticleList.size();
    }
}
