package com.jash.qswiki.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.jash.qswiki.R;
import com.jash.qswiki.adapters.ArticleItemAdapter;
import com.jash.qswiki.entities.ArticleResult;
import com.jash.qswiki.utils.HttpUtils;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleFragment extends Fragment implements Callback<ArticleResult> {


    private ArticleItemAdapter adapter;
    private String type;

    public ArticleFragment() {
        // Required empty public constructor
    }

    public static ArticleFragment newInstance(String type) {

        Bundle args = new Bundle();
        
        ArticleFragment fragment = new ArticleFragment();
        args.putString("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        type = getArguments().getString("type");
        ListView list = (ListView) view.findViewById(R.id.article_list);
        adapter = new ArticleItemAdapter(getContext());
        list.setAdapter(adapter);
        Call<ArticleResult> article = HttpUtils.getService().getArticle(type, 1);
        article.enqueue(this);
    }

    @Override
    public void onResponse(Response<ArticleResult> response, Retrofit retrofit) {
        adapter.addAll(response.body().getList());
    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
        Toast.makeText(getContext(), "网络问题", Toast.LENGTH_SHORT).show();
    }
}
