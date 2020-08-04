package com.example.spy;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;
import java.util.Queue;

public class Reloader extends AsyncTaskLoader<List<Model>>{

    private String mUrl;

    public Reloader(Context context, String url) {
        super(context);
        this.mUrl = url;
    }

    @Override
    protected  void onStartLoading() {

        forceLoad();
    }


    @Override
    public List<Model> loadInBackground() {

        if (mUrl == null) {

            return null;

        }


        List<Model> news = Utils.fetchNews(getContext(), mUrl);
        return news;


    }

}
