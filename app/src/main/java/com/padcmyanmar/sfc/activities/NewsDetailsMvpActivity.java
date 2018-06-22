package com.padcmyanmar.sfc.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.sfc.R;
import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.mvp.presenters.NewsDetailsPresenter;
import com.padcmyanmar.sfc.mvp.views.NewsDetailsView;
import com.padcmyanmar.sfc.mvp.views.NewsListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailsMvpActivity extends BaseActivity implements NewsDetailsView{

    private static final String IE_NEWS_ID = "IE_NEWS_ID";

    private NewsDetailsPresenter mNewsDetailsPresenter;

    @BindView(R.id.tv_news_details_brief)
    TextView tvNewsBrief;

    @BindView(R.id.tv_news_details_publication_name)
    TextView tvPublicationName;

    @BindView(R.id.tv_news_details_posted_date)
    TextView tvPostedDate;

    @BindView(R.id.iv_news_details_image_mvp)
    ImageView ivNewsDetailsImage;

    @BindView(R.id.tv_news_details)
    TextView tvNewsDetials;


    public static Intent newIntent(Context context, String newsId){
        Intent intent = new Intent(context, NewsDetailsMvpActivity.class);
        intent.putExtra(IE_NEWS_ID, newsId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details_mvp);
        ButterKnife.bind(this, this);

        mNewsDetailsPresenter = new NewsDetailsPresenter(this);
        mNewsDetailsPresenter.onCreate();

        String newsId = getIntent().getStringExtra(IE_NEWS_ID);
        mNewsDetailsPresenter.onFinishedUIComponentSetup(newsId);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mNewsDetailsPresenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNewsDetailsPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mNewsDetailsPresenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mNewsDetailsPresenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mNewsDetailsPresenter.onDestroy();
    }

    @Override
    public void newsDetailsView(NewsVO news) {
        tvNewsBrief.setText(news.getBrief());
        tvPublicationName.setText(news.getPublication().getTitle());
        tvPostedDate.setText(news.getPostedDate());
        tvNewsDetials.setText(news.getDetails());

        if(!news.getImages().isEmpty()){
            Glide.with(ivNewsDetailsImage.getContext())
                    .load(news.getImages())
                    .into(ivNewsDetailsImage);
        } else {
            ivNewsDetailsImage.setVisibility(View.GONE);
        }
    }

    @Override
    public void displayErrorMsg(String errorMsg) {

    }
}
