package ro.atelieruldigital.news.model;

import java.util.List;

public class NewsListResponse {
    private String status;
    private int totalResults;
    private List<ArticleResponse> articlesResponse;

    public String getStatus() {
        return status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public List<ArticleResponse> getArticles() {
        return articlesResponse;
    }
}
