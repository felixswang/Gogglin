package com.learnopengles.android.lesson4;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by shwang on 7/17/14.
 */
public class NetworkUtils {
    public static void getQuestion(int start, Callback<CardBoardQuestion> callback) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://dhuang-ld1.linkedin.biz:8080")
                .build();
        GetCardBoardQuestion getCardBoardQuestion = restAdapter.create(GetCardBoardQuestion.class);
        getCardBoardQuestion.listRepos(start, callback);
    }

    public interface GetCardBoardQuestion {
        @GET("/cardBoard")
        void listRepos(@Query("start") int start, Callback<CardBoardQuestion> questionCallback);
    }
}
