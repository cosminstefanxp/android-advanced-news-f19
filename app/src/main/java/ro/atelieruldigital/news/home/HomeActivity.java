package ro.atelieruldigital.news.home;

import android.os.Bundle;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ro.atelieruldigital.news.R;
import ro.atelieruldigital.news.core.BaseActivity;
import ro.atelieruldigital.news.model.NewsListResponse;
import ro.atelieruldigital.news.model.ws.NewsWebService;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getDataFromServer();
    }

    private void getDataFromServer() {
        NewsWebService newsWebService = new NewsWebService();
        Call<NewsListResponse> newsListResponseCall = newsWebService.queryArticles("bitcoin");
        newsListResponseCall.enqueue(new Callback<NewsListResponse>() {
            @Override
            public void onResponse(Call<NewsListResponse> call, Response<NewsListResponse> response) {
                System.out.println("print: " + response.body().getStatus());

            }

            @Override
            public void onFailure(Call<NewsListResponse> call, Throwable t) {
                System.out.println("failure: " );

            }
        });

//        try {
//            Response<NewsListResponse> response = newsListResponseCall.execute();
//            NewsListResponse newsListResponse = response.body();
//            System.out.println("response: " + response.body().getStatus());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
