package com.padcmyanmar.sfc.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.sfc.R;
import com.padcmyanmar.sfc.data.vo.NewsVO;

import org.w3c.dom.Text;

import butterknife.BindView;

public class NewsViewHolderMVP extends BaseViewHolder<NewsVO> {

    @BindView(R.id.iv_news_image)
    ImageView ivNewsImage;

    @BindView(R.id.iv_publication_logo)
    ImageView ivPublicationLogo;

    @BindView(R.id.tv_publication_name)
    TextView tvPublicationName;

    @BindView(R.id.tv_brief_news)
    TextView tvBriefNews;

    @BindView(R.id.tv_posted_date)
    TextView tvPostedDate;

    public NewsViewHolderMVP(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(NewsVO data) {

        tvBriefNews.setText(data.getDetails());
        tvPublicationName.setText(data.getPublication().getTitle());
        tvPostedDate.setText(data.getPostedDate());

        if (!data.getImages().isEmpty()){
            Glide.with(ivNewsImage.getContext())
                    .load(data.getImages().get(0))
                    .into(ivNewsImage);
        } else {
            ivNewsImage.setVisibility(View.GONE);
        }

        Glide.with(ivPublicationLogo.getContext())
                .load(data.getPublication().getLogo())
                .into(ivPublicationLogo);
    }

    @Override
    public void onClick(View v) {

    }
}
