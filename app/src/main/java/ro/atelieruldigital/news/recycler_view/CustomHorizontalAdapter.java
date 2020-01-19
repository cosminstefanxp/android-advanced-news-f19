package ro.atelieruldigital.news.recycler_view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ro.atelieruldigital.news.App;
import ro.atelieruldigital.news.R;
import ro.atelieruldigital.news.model.ArticleResponse;

public class CustomHorizontalAdapter extends RecyclerView.Adapter<CustomHorizontalViewHolder> {

    private ArrayList<ArticleResponse.Article> mArticleList;

    public CustomHorizontalAdapter(ArrayList<ArticleResponse.Article> articleList) {
        this.mArticleList = articleList;
    }

    @NonNull
    @Override
    public CustomHorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomHorizontalViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_layout_news_card,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHorizontalViewHolder holder, int position) {
        holder.mTextViewTitle.setText(mArticleList.get(position).getTitle());
        holder.mTextViewDescription.setText(mArticleList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mArticleList.size();
    }

}
