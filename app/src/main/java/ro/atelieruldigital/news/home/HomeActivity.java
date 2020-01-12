package ro.atelieruldigital.news.home;

import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import ro.atelieruldigital.news.R;
import ro.atelieruldigital.news.core.BaseActivity;
import ro.atelieruldigital.news.model.ArticleResponse;
import ro.atelieruldigital.news.model.NewsAPIRequests;
import ro.atelieruldigital.news.model.WebService.NewsWebService;
import timber.log.Timber;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getDataFromServer();
    }

    private void getDataFromServer() {
        Retrofit newsWebServiceRetrofit = NewsWebService.getRetrofitClient();
        NewsAPIRequests newsAPIRequests = newsWebServiceRetrofit.create(NewsAPIRequests.class);

        Call<ArticleResponse> call = newsAPIRequests.queryArticles("apple", "2019-12-12", "2020-01-03",
                "popularity", "4b3b375b6f9e462b8513e1471c5428b9");

        call.enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                if (response.body() != null) {
                    ArticleResponse articleResponse = response.body();

                    System.out.println("ESTE K XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                    System.out.println(articleResponse.getStatus());
                    System.out.println(articleResponse.getTotalResults());
                    System.out.println(articleResponse.getArticles());
//                    System.out.println(articleResponse.getArticles().get(0).getArticleURL());
//                    System.out.println(articleResponse.getArticles().get(2).getAuthor());
//                    System.out.println(articleResponse.getArticles().get(3).getContent());
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
