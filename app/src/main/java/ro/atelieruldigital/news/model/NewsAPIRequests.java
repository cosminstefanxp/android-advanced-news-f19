package ro.atelieruldigital.news.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsAPIRequests {
    // TODO: Add functionality according to API
    // TODO: To be used as Retrofit's API

    @GET("v2/everything")
    Call<ArticleResponse> queryArticles(@Query("q") String searchString,
                                        @Query("from") String from,
                                        @Query("to") String to,
                                        @Query("SortBy") String sort,
                                        @Query("apiKey") String apiKey);
}
