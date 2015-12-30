package com.jash.qswiki.utils;

import com.jash.qswiki.entities.ArticleResult;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by jash
 * Date: 15-12-30
 * Time: 下午3:18
 */
public class HttpUtils {
    public interface Service{
        @GET("/article/list/{type}")
        Call<ArticleResult> getArticle(@Path("type") String type, @Query("page") int page);
    }

    private static Service service;

    static {
        service = new Retrofit.Builder().baseUrl("http://m2.qiushibaike.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Service.class);
    }

    public static Service getService() {
        return service;
    }
}
