package ro.atelieruldigital.news;

import android.app.Application;
import android.content.Context;

import com.jakewharton.threetenabp.AndroidThreeTen;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import ro.atelieruldigital.news.model.ArticleResponse;
import ro.atelieruldigital.news.model.ws.NewsAPIService;
import ro.atelieruldigital.news.model.ws.NewsWebService;
import timber.log.Timber;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG)
            Timber.plant(new Timber.DebugTree());

        AndroidThreeTen.init(this);

        Timber.d("App has initialized...");

        init();
    }

    private void init() {
        Retrofit newsWebServiceRetrofit = NewsWebService.getRetrofitClient();
        NewsAPIService newsAPIService = newsWebServiceRetrofit.create(NewsAPIService.class);

        Call<ArticleResponse> call = newsAPIService.queryArticles("apple","2019-12-12","2020-01-03",
                "popularity","4b3b375b6f9e462b8513e1471c5428b9");

        call.enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                if (response.body()!=null){
                     ArticleResponse articleResponse = response.body();

                    System.out.println("ESTE K XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                    System.out.println(articleResponse.getArticles().get(1).getDescription());
                    System.out.println(articleResponse.getArticles().get(0).getArticleURL());
                    System.out.println(articleResponse.getArticles().get(2).getAuthor());
                    System.out.println(articleResponse.getArticles().get(3).getContent());
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Timber.e(t, "Failed to get data:");
                System.out.println("Fail to GET data");

            }
        });
    }
}
