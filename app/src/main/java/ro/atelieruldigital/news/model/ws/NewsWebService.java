package ro.atelieruldigital.news.model.ws;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ro.atelieruldigital.news.App;
import ro.atelieruldigital.news.R;
import ro.atelieruldigital.news.model.NewsListResponse;

public class NewsWebService {
    // TODO: Add functionality according to API

    // TODO: Load Token
    private static final String API_KEY = "534a091354c14911aa44a800e5270924";
    private NewsApi newsApi;

    public NewsWebService() {
        // TODO: Initialize newsApi with Retrofit
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        NewsApi newsApi = retrofit.create(NewsApi.class);
        this.newsApi = newsApi;
    }

    public Call<NewsListResponse> queryArticles(String searchString) {
        return newsApi.queryArticles(searchString, API_KEY);
    }

    private interface NewsApi {
        // TODO: Add functionality according to API
        // TODO: To be used as Retrofit's API

        @GET("/v2/everything")
        Call<NewsListResponse> queryArticles(@Query("q") String searchString,
                                             @Query("apikey") String apiKey);
    }
}
