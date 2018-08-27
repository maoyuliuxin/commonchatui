package com.iflytek.chatdetails.defaultviewholder;

import android.view.View;
import android.widget.ImageView;

import com.github.lzyzsd.circleprogress.CircleProgress;
import com.iflytek.chatdetails.R;
import com.iflytek.chatdetails.base.BaseViewHolder;
import com.iflytek.chatdetails.constant.StateConstant;
import com.iflytek.chatdetails.event.EventImage;
import com.iflytek.chatdetails.event.EventSendError;
import com.iflytek.chatdetails.intf.IMessage;
import com.iflytek.chatdetails.manage.LoadImageManage;

import org.greenrobot.eventbus.EventBus;

/**
 * description:
 * data: 2018/8/15
 * email: qiangshen2@iflytek.com
 *
 * @author : qiangshen2
 */
public class DefaultLeftImageViewHolder<T extends IMessage> extends BaseViewHolder<T> {


    private ImageView mImageView;
    private CircleProgress mProgressLoad;
    private ImageView mIvError;

    public DefaultLeftImageViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setView(View itemView) {
        mImageView = itemView.findViewById(R.id.iv_left);
        mProgressLoad = itemView.findViewById(R.id.progress_load);
        mIvError = itemView.findViewById(R.id.iv_error);
        mIvError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new EventSendError<T>(mMessage));
            }
        });
        mProgressLoad.setAlpha(0.5f);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new EventImage<>(mMessage));
            }
        });
    }

    @Override
    public void setBind(T message) {
        LoadImageManage.loadImage(message.getFileUrl(), mImageView);
        if (message.getFileLoadProgress() == StateConstant.SUCCESS_LOAD) {
            mProgressLoad.setVisibility(View.GONE);
            mIvError.setVisibility(View.GONE);
        } else if (message.getFileLoadProgress() == StateConstant.DEFEAT_LOAD) {
            mIvError.setVisibility(View.VISIBLE);
            mProgressLoad.setVisibility(View.GONE);
        } else {
            mProgressLoad.setVisibility(View.VISIBLE);
            mIvError.setVisibility(View.GONE);
            mProgressLoad.setProgress(message.getFileLoadProgress());
        }
    }

    @Override
    public int getHeaderViewId() {
        return R.id.iv_header;
    }

    @Override
    public int getTimeViewId() {
        return R.id.tv_header_time;
    }
}
