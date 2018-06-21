package com.padcmyanmar.sfc.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.sfc.R;
import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.viewholders.NewsViewHolderMVP;

public class NewsAdapterMVP extends BaseRecyclerAdapter<NewsViewHolderMVP, NewsVO> {

    public NewsAdapterMVP(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public NewsViewHolderMVP onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View newsItem = mLayoutInflator.inflate(R.layout.view_item_news_mvp,parent,false);
        return new NewsViewHolderMVP(newsItem);
    }
}
