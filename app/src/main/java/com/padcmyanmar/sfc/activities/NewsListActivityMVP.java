package com.padcmyanmar.sfc.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.padcmyanmar.sfc.R;
import com.padcmyanmar.sfc.adapters.NewsAdapterMVP;
import com.padcmyanmar.sfc.components.SmartRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsListActivityMVP extends BaseActivity {

    @BindView(R.id.rv_news)
    SmartRecyclerView rvNews;

    private NewsAdapterMVP mNewsAdapterMVP;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list_mvp);
        ButterKnife.bind(this,this);

        rvNews.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        mNewsAdapterMVP = new NewsAdapterMVP(getApplicationContext());
        rvNews.setAdapter(mNewsAdapterMVP);
    }
}
