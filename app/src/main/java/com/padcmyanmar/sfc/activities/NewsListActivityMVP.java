package com.padcmyanmar.sfc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.padcmyanmar.sfc.R;
import com.padcmyanmar.sfc.adapters.NewsAdapterMVP;
import com.padcmyanmar.sfc.components.SmartRecyclerView;
import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.mvp.presenters.NewsListPresenter;
import com.padcmyanmar.sfc.mvp.views.NewsListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsListActivityMVP extends BaseActivity
            implements NewsListView{

    @BindView(R.id.rv_news)
    RecyclerView rvNews;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private NewsAdapterMVP mNewsAdapterMVP;

    private NewsListPresenter mNewsListPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list_mvp);
        ButterKnife.bind(this,this);

        setSupportActionBar(toolbar);

        mNewsListPresenter = new NewsListPresenter(this);
        mNewsListPresenter.onCreate();

        rvNews.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        mNewsAdapterMVP = new NewsAdapterMVP(getApplicationContext());
        rvNews.setAdapter(mNewsAdapterMVP);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mNewsListPresenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNewsListPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mNewsListPresenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mNewsListPresenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mNewsListPresenter.onDestroy();
    }

    @Override
    public void displayNewsList(List<NewsVO> newsList) {
        mNewsAdapterMVP.appendNewData(newsList);
    }

    @Override
    public void displayErrorMsg(String errMsg) {
        Snackbar.make(rvNews, errMsg, Snackbar.LENGTH_INDEFINITE).show();
    }

    @Override
    public void launchNewsDetailsScreen(String newsId) {
        Intent intent = NewsDetailsActivity.newIntent(getApplicationContext(),newsId);
        startActivity(intent);
    }
}
